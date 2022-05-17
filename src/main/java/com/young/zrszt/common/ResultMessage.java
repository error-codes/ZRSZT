package com.young.zrszt.common;

/**
 * @author error-codes 【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/12 23:33
 */
public class ResultMessage {

    /********************************************
     *                                          *
     *              默认返回信息                  *
     *                                          *
     *******************************************/
    public static final String SUCCESS = "请求成功处理";
    public static final String ERROR = "服务器内部发生错误";
    public static final String UNAUTHORIZED = "暂未登录或Token已经过期";
    public static final String FORBIDDEN = "没有相关权限";
    public static final String VALIDATE_FAILED = "参数校验失败";
    public static final String FAILED = "请求成功处理，但操作失败";


    /********************************************
     *                                          *
     *                通用的返回信息               *
     *                                          *
     *******************************************/
    public static final String ADD_SUCCESS = "新增成功！";
    public static final String ADD_FAILED = "新增失败！";
    public static final String REGISTER_SUCCESS = "注册成功！";
    public static final String REGISTER_FAILED = "注册失败！";
    public static final String DELETE_SUCCESS = "删除成功！";
    public static final String DELETE_FAILED = "删除失败！";
    public static final String UPDATE_SUCCESS = "修改成功！";
    public static final String UPDATE_FAILED = "修改失败！";
    public static final String QUERY_SUCCESS = "查询成功！";
    public static final String QUERY_FAILED = "查询失败！";
    public static final String BAN_SUCCESS = "禁用成功";
    public static final String BAN_FAILED = "禁用失败";
    public static final String PICK_SUCCESS = "启用成功";
    public static final String PICK_FAILED = "启用失败";
    public static final String EXPORT_SUCCESS = "导出成功";
    public static final String EXPORT_FAILURE = "导出失败";
    public static final String IMPORT_SUCCESS = "导入成功";
    public static final String IMPORT_FAILURE = "导入失败";
    public static final String UPLOAD_SUCCESS = "上传成功";
    public static final String UPLOAD_FAILED = "上传失败";
    public static final String LOGIN_SUCCESS = "登录成功";
    public static final String LOGIN_FAILURE = "登录失败";
    public static final String LOGOUT_SUCCESS = "下线成功";
    public static final String LOGOUT_FAILURE = "下线失败";
    public static final String REFRESH_SUCCESS = "刷新成功";
    public static final String REFRESH_FAILURE = "刷新失败";
    public static final String CLAIM_SUCCESS = "认领申请递交成功";
    public static final String END_CLAIM_SUCCESS = "结束认领成功";
    public static final String CLAIM_FAILURE = "认领申请递交失败";
    public static final String END_CLAIM_FAILURE = "结束认领失败";

    /********************************************
     *                                          *
     *              信息或属性不存在               *
     *                                          *
     *******************************************/
    public static final String USER_NOT_EXIST = "用户不存在";
    public static final String TASK_NOT_EXIST = "任务不存在";
    public static final String ADVICE_NOT_EXIST = "通知不存在";
    public static final String ACCEPT_NOT_EXIST = "成果不存在";
    public static final String TASK_OR_USER_NOT_EXIST = "任务或用户不存在";
    public static final String YOUNG_FILE_NOT_EXIST = "文件不存在";
    public static final String RESUME_NOT_EXIST = "文件不存在";
    public static final String VIDEO_NOT_EXIST = "视频不存在";
    public static final String TASK_EXIST = "任务已存在";
    public static final String PROJECT_NOT_EXIST = "项目不存在";
    public static final String PROJECT_EXIST = "项目已存在";
    public static final String SERVICE_NOT_EXIST = "服务不存在";
    public static final String SERVICE_EXIST = "服务已存在";
    public static final String CLAIM_NOT_EXIST = "认领信息不存在";
    public static final String REAL_NAME_VERIFY_NOT_EXIST_OR_PROCESSED = "待实名审核信息不存在或已处理";


    /********************************************
     *                                          *
     *                审核类返回信息               *
     *                                          *
     *******************************************/
    public static final String REAL_NAME_VERIFY_PASS = "通过该用户的实名审核申请";
    public static final String CLAIM_PASS = "通过该用户的任务认领申请";
    public static final String REAL_NAME_VERIFY_REJECT = "拒绝该用户的实名审核申请";
    public static final String CLAIM_REJECT = "拒绝该用户的任务认领申请";
    public static final String REAL_NAME_VERIFY_FAILED = "对该用户的实名审核失败，请检查之后重新尝试";
    public static final String CLAIM_FAILED = "对该用户的任务认领申请审核失败，请检查之后重新尝试";
    public static final String TASK_RESULT_VERIFY_FINAL = "该用户的任务成果审核完成";
    public static final String TASK_RESULT_FK_SUBMIT = "任务成果意见已反馈";
    public static final String TASK_RESULT_VERIFY_FAILED = "对该用户的任务成果审核失败，请检查之后重新尝试";

    /********************************************
     *                                          *
     *            其他自定义返回信息               *
     *                                          *
     *******************************************/
    public static final String PHONE_REGISTERED = "手机号已经注册";
    public static final String PHONE_FORMAT_ERROR = "手机号格式错误，请检查后重新输入";
    public static final String USERNAME_REGISTERED = "用户名已经注册";
    public static final String VERIFY_CODE_ERROR = "验证码输入错误";
    public static final String USER_INPUT_ERROR = "您输入的数据格式错误或您没有权限访问资源";
    public static final String SYSTEM_ERROR = "系统出现异常，请您稍后再试或联系管理员！";
    public static final String INPUT_DATA_EXIST = "您输入的数据与现有数据重复，请检查之后重新输入";
    public static final String NOT_EXIST_DATA = "不存在此条数据，请查验输入信息是否正确";
    public static final String CANNOT_ACCESS_SYSTEM_RESOURCES = "认证失败，无法访问系统资源";
    public static final String CURRENT_USER_LOGGED_ELSEWHERE = "当前用户已在其他地方登录";
    public static final String USERNAME_PASSWORD_NOT_NULL = "用户名或密码不能为空";
    public static final String PHONE_VERIFY_CODE_NOT_NULL = "手机号或验证码不能为空";
    public static final String RESUME_NOT_MORE_THAN_THREE = "简历最大只能保存三份";
    public static final String TASK_DATE_NOT_MORE_THAN_PROJECT = "任务周期不能超过项目周期";
    public static final String PROJECT_COUNT_EXIST = "该项目本月项目统计已填报，请勿重复填报";
    public static final String ACCOUNT_NOT_EXIST_PASSWORD_ERROR = "账户不存在或密码错误";
    public static final String VERIFY_CODE_INPUT_ERROR = "验证码输入错误";
    public static final String USER_AUTHENTICATION_FAILURE = "用户身份验证失败";

}
