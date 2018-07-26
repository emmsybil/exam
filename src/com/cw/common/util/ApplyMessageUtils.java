package com.cw.common.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;

import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 报名信息帮助类
 * 
 * @author yuanguangjie
 *
 */
public class ApplyMessageUtils {

	// 创建log
	static Logger LOG = Logger.getLogger(ApplyMessageUtils.class);

	public static JSONArray getApplyMessage(String startTime, String endTime) {
		// 返回结果
		JSONObject result = new JSONObject();

		// 创建json数组
		JSONArray jsonArray = new JSONArray();

		try {
			// 创建HttpClient实例
			BasicHttpClientConnectionManager connManager = new BasicHttpClientConnectionManager(
					RegistryBuilder.<ConnectionSocketFactory> create()
							.register("http", PlainConnectionSocketFactory.getSocketFactory())
							.register("https", SSLConnectionSocketFactory.getSocketFactory()).build(),
					null, /* Default ConnectionFactory */
					null, /* Default SchemePortResolver */
					null /* Default DnsResolver */
			);
			HttpClient client = HttpClientBuilder.create().setConnectionManager(connManager).build();

			// 设置请求地址
			String url = "http://www.cwfoodmeet.com/cashier/api/apply-messsage/in-step";

			// UrlEncodedFormEntity设置实体
			List<NameValuePair> fromParams = new ArrayList<NameValuePair>();
			fromParams.add(new BasicNameValuePair("startTime", startTime));
			fromParams.add(new BasicNameValuePair("endTime", endTime));

			UrlEncodedFormEntity urlEntity = new UrlEncodedFormEntity(fromParams, "UTF-8");

			LOG.debug("请求的url---》》" + url);

			// 创建post请求
			HttpPost post = new HttpPost(url);

			// 设置请求实体
			post.setEntity(urlEntity);

			// 请求url，获取
			HttpResponse response = client.execute(post);

			// 获取请求返回状态值
			int statusCode = response.getStatusLine().getStatusCode();

			LOG.debug("请求报名信息地址返回状态值：" + statusCode);

			// 获取请求返回实体值
			String entity = EntityUtils.toString(response.getEntity());
			LOG.debug("请求报名信息地址返回实体值：" + entity);

			// 获取解析的json对象
			result = JSONObject.fromObject(entity);

			// 获取返回数据的状态
			String responseResult = result.getString("result");

			// 返回数据为成功时
			if ("success".equals(responseResult)) {

				// 获取json数组
				jsonArray = result.getJSONArray("object");

			}
			
			LOG.debug("查看请求返回的数据---》" + jsonArray.toString());
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error("获取报名数据值发生错误：" + e.getMessage());
		}

		return jsonArray;
	}

}
