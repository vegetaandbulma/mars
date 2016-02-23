package com.nagao.framework.http;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author nadonghua 负责具体的 http 请求工作,当请求失败后，会根据情况自动重试
 * 代码参考 http://hc.apache.org/httpcomponents-client-ga/httpclient/examples/org/apache/http/examples/client/ClientConfiguration.java
 */
public class HttpWorker {
	private static final Logger log = LoggerFactory.getLogger(HttpWorker.class);
	/**
	 * 
	 * @param post get post 方式
	 * @param uri url
	 * @param param 参数
	 * @param charset 字符
	 * @return
	 */
	public static Map<String, Object> worker(boolean post, String uri,Map<String, String> param, String charset) {
		long start = System.currentTimeMillis();
		try {
			
			return HttpWorker.http(post, uri, param, null,charset,3000,75000);
		} catch (Exception e) {
			long end = System.currentTimeMillis();
			log.error("HttpWorker has a exception start:["+ start +"] end:["+ end +"] use:[" + (end -start) + "]");
			log.error("HttpWorker has a exception uri:" + uri + " exception:" + e.getLocalizedMessage() + "  cause:" + e.getCause(),e); 
			return new HashMap<String,Object>();
		}
	}
	/**
	 * 
	 * @param post
	 * @param uri
	 * @param param
	 * @param charset
	 * @param connectTimeout 链接超时时间
	 * @param socketTimeout  读取超时时间
	 * @return
	 */
	public static Map<String, Object> worker(boolean post, String uri,Map<String, String> param, String charset,int connectTimeout,int socketTimeout) {
		long start = System.currentTimeMillis();
		try {
			return HttpWorker.http(post, uri, param, null,charset,connectTimeout,socketTimeout);
		} catch (Exception e) {
			long end = System.currentTimeMillis();
			log.error("HttpWorker has a exception start:["+ start +"] end:["+ end +"] use:[" + (end -start) + "]");
			log.error("HttpWorker has a exception uri:" + uri + " exception:" + e.getLocalizedMessage() + "  cause:" + e.getCause(),e);
			return new HashMap<String,Object>();
		}
	}
	
	private static Map<String, Object> http(boolean post, String uri,Map<String, String> param,Header header, String charset,int connectTimeout,int socketTimeout) throws Exception {
		Map<String, Object> data = new HashMap<String, Object>();

		CloseableHttpClient httpClient = (CloseableHttpClient) HttpClientFactory.generateCilent();

		List<NameValuePair> paramList = new ArrayList<NameValuePair>();
		for (Entry<String, String> entry : param.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			BasicNameValuePair basic = new BasicNameValuePair(key, value);
			paramList.add(basic);
		}
		
		if(socketTimeout <=0 || socketTimeout > 120000){
			socketTimeout = 30000;
		}
		if(connectTimeout <=0 || connectTimeout > 12000){
			connectTimeout = 3000;
		}
		
		RequestConfig requestConfig = RequestConfig.custom()
				.setSocketTimeout(socketTimeout)	//读取超时
				.setConnectTimeout(connectTimeout)	//连接超时
				.build();							//设置请求和传输超时时间

		CloseableHttpResponse httpResponse = null;


		if (post) {
			HttpPost httpPost = new HttpPost(uri);
			httpPost.setEntity(new UrlEncodedFormEntity(paramList, charset));
			httpPost.setConfig(requestConfig);
			httpPost.addHeader(header);
			httpResponse = (CloseableHttpResponse) httpClient.execute(httpPost);
		} else {
			if (uri.indexOf("?") < 0) {
				uri = uri + "?";
			}
			String url = uri + URLEncodedUtils.format(paramList, charset);
			HttpGet httpGet = new HttpGet(url);
			httpGet.setConfig(requestConfig);
			httpGet.addHeader(header);
			httpResponse = (CloseableHttpResponse) httpClient.execute(httpGet);
		}

		try {
			
			String content = null;
			String responseCode = null;
			String contentType = null;
			int statusCodeInt = 0;
			
			HttpEntity entity = httpResponse.getEntity();
			if (entity != null) {
				content = EntityUtils.toString(entity);
				EntityUtils.consume(entity);
			}
			
			statusCodeInt = httpResponse.getStatusLine().getStatusCode();
			Header head = httpResponse.getFirstHeader("result-code");
			if (head != null) {
				responseCode = head.getValue();
			}
			Header headCntType = httpResponse.getLastHeader("Content-Type");
			if (headCntType != null){
				contentType = headCntType.getValue();
			}
			data.put("statusCode", statusCodeInt+"");
			data.put("entity", content);
			data.put("result-code", responseCode);
			data.put("contentType", contentType);
		} finally {
			httpResponse.close();
		}
		return data;
	}
}
