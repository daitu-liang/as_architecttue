package com.kakaxi.androidmvp.utils;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.kakaxi.androidmvp.app.App;
import com.kakaxi.androidmvp.model.user.UserInfo;


public class UserUtil {
	private static Logger log = Logger.getLogger("UserUtil");
	// 用户信息
	public static UserInfo userInfo=null;

	public static String getUid() {
		if (hasLogin()) {
			return userInfo.getUser_id();
		}
		return null;
	}

	public static String getDepartmentId() {
		if (hasLogin()) {
			return userInfo.getDepartment_id();
		}
		return null;
	}
	public static String getUserName() {
		if (hasLogin()) {
			return userInfo.getName();
		}
		return null;
	}
	public static String getBossType() {
		if (hasLogin()) {
			return userInfo.getDisplay_instructions_view();
		}
		return null;
	}
	public static String getHasPush() {
		if (hasLogin()) {
			return userInfo.getPush();
		}
		return null;
	}
	/**
	 * 判断是否登录
	 * 
	 * @return true登录 | false未登录
	 */
	public static boolean hasLogin() {
		if (userInfo == null) {
			
			initUserInfo();
		}
		return (null != userInfo && !TextUtils.isEmpty(userInfo.getUser_id()));
	}
	public static boolean needTokenToService() {
		if (hasLogin()&& TextUtils.isEmpty(userInfo.getPushToken())) {
			return true;
		}
		return false;
	}
	/**
	 * 保存用户数据
	 */
	public static void saveUserInfo() {
		try {
			String userJson = new Gson().toJson(userInfo);
			FileUtil.writeFile(App.CONTEXT,
					ConstUtils.FileName.USER_INFO, userJson);
		} catch (Exception e) {
		}
		initUserInfo();
	}

	/**
	 * 保存并处理登录信息
	 * 
	 * @param data
	 */
	public static void dealLoginResponse(UserInfo data) {

		try {

				if(userInfo==null){
					userInfo=new UserInfo();
				}
			
			UserUtil.userInfo.setUser_id(data.getUser_id());
			UserUtil.userInfo.setName(data.getName());

			UserUtil.userInfo.setHeadimg(data.getHeadimg());
			UserUtil.userInfo.setDepartment(data.getDepartment());
			UserUtil.userInfo.setTel(data.getTel());
			UserUtil.userInfo.setPosition(data.getPosition());
			UserUtil.userInfo.setDepartment_id(data.getDepartment_id());
			UserUtil.userInfo.setDisplay_instructions_view(data.getDisplay_instructions_view());
			UserUtil.userInfo.setPush(data.getPush());
		} catch (Exception e) {
			e.printStackTrace();
		}
		UserUtil.saveUserInfo();
	}



	private static void initUserInfo() {
		String userInfoText = FileUtil.readFile(App.CONTEXT,
				ConstUtils.FileName.USER_INFO);
		if (!TextUtils.isEmpty(userInfoText)) {
			try {
				userInfo = new Gson().fromJson(userInfoText, UserInfo.class);
			} catch (Exception e) {
				userInfo = null;
			}
		} else {
			userInfo = null;
		}
	}

	/**
	 * 退出登录
	 */
	public static void logout() {
		FileUtil.writeFile(App.CONTEXT, ConstUtils.FileName.USER_INFO, "");
		userInfo = null;
		initUserInfo();
		PreferencesManager.getInstance(App.CONTEXT).logout();
		ScreenManager.clearActivityList();
	}
	
}
