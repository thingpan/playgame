package com.playgame.service;

import java.util.List;
import java.util.Map;

public interface UserInfoService {
List<Map<String,String>>SelectUserInfoList(Map<String,String>user);
Map<String,String>SelectUserInfo(String uiNum);
int insertUserInfo(Map<String,String> user);
int updateUserInfo(Map<String,String>user);
int deleteUserInfo(String uiNum);
Map<String,String> login(String userId);
}
