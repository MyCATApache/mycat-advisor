/*
 * Copyright (c) 2015 传化科技服务有限公司(Transfar Group) All rights reserved
 */

package org.apache.mycat.advisor.common.net.sms;


import org.apache.mycat.advisor.common.net.http.HttpService;

import java.util.HashMap;
import java.util.Map;

/**
 * package: com.transfar.greentech.common.net.sms </br>
 * functional describe:发送短信，使用云片接口
 *
 * @author DR.YangLong [410357434@163.com]
 * @version 1.0    2015/7/1 13:13
 */
public class YunpianSms {
    //账户信息查询接口
    private static final String ACCOUNT_INFO="http://yunpian.com/v1/user/get.json";
    //账户修改接口
    private static final String ACCOUNT_MODIFY="http://yunpian.com/v1/user/set.json";
    //取消默认模板
    private static final String TEMPLATE_CANCLE="http://yunpian.com/v1/tpl/get_default.json";
    //添加模板
    private static final String TEMPLATE_CREATE="http://yunpian.com/v1/tpl/add.json";
    //获取模板
    private static final String TEMPLATE_GET="http://yunpian.com/v1/tpl/get.json ";
    //更新模板
    private static final String TEMPLATE_UPDATE="http://yunpian.com/v1/tpl/update.json";
    //发送短信
    private static final String SMS_SEND="http://yunpian.com/v1/sms/send.json";
    //获取状态报告
    private static final String SMS_SEND_STATUS="http://yunpian.com/v1/sms/pull_status.json";
    //获取回复短信
    private static final String SMS_SEND_FEEDBACK="http://yunpian.com/v1/sms/pull_reply.json";
    //查回复短信
    private static final String SMS_FEEDBACK_PAGE="http://yunpian.com/v1/sms/get_reply.json";
    //语音验证码
    private static final String VEDIAO_VALIDATE="http://voice.yunpian.com/v1/voice/send.json";
    //云片网api key
    private String apiKey;

    /**
     * 发送短信
     * @param content 内容
     * @param mobile 手机号
     * @return 返回字符串
     */
    public String sendSms(String content,String mobile){
        Map<String, String> params = new HashMap<String, String>();
        params.put("apikey", this.getApiKey());
        params.put("text", content);
        params.put("mobile", mobile);
        String result= HttpService.doHttpClientPost(SMS_SEND, params);
        return result;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
