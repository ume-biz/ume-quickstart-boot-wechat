/*
 * Copyright 2014_2017 UME Framework Group, Apache License Version 2.0
 */
package org.umeframework.quickstart.uac.message;

/**
 * MessageConst
 * 
 * @author Yue Ma
 *
 */
public interface MessageConst {
	// User authentication message
	String UME_UAC_MSG_001 = "UME_UAC_MSG_001::User not exist.";
	String UME_UAC_MSG_002 = "UME_UAC_MSG_002::Please input correct user password.";
	String UME_UAC_MSG_003 = "UME_UAC_MSG_003::User was disable currently.";
	// User authentication message
	String UME_WECHAT_UAC_MSG_001 = "UME_WECHAT_UAC_MSG_001::微信回调Code取得失败。";
	String UME_WECHAT_UAC_MSG_002 = "UME_WECHAT_UAC_MSG_002::openid[{0}]对应的业务用户创建·更新失败。";
	String UME_WECHAT_UAC_MSG_003 = "UME_WECHAT_UAC_MSG_003::openid[{0}]对应的业务用户状态{0}错误。";
	String UME_WECHAT_UAC_MSG_004 = "UME_WECHAT_UAC_MSG_002::发现openid[{0}]重复的业务用户。";

}
