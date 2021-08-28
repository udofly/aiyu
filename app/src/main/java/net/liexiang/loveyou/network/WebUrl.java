package net.liexiang.loveyou.network;

/**
 * @Describe: WebUrl
 * @Created by Gao Chunfa on 2017/11/23.
 * @Company: Shandong LieXiang Network Technology Co. Ltd
 * @Copyright © 2018年 Gao Chunfa. All rights reserved.
 * <p>
 * #####################################################
 * #                                                   #
 * #                       _oo0oo_                     #
 * #                      o8888888o                    #
 * #                      88" . "88                    #
 * #                      (| -_- |)                    #
 * #                      0\  =  /0                    #
 * #                    ___/`---'\___                  #
 * #                  .' \\|     |# '.                 #
 * #                 / \\|||  :  |||# \                #
 * #                / _||||| -:- |||||- \              #
 * #               |   | \\\  -  #/ |   |              #
 * #               | \_|  ''\---/''  |_/ |             #
 * #               \  .-\__  '-'  ___/-. /             #
 * #             ___'. .'  /--.--\  `. .'___           #
 * #          ."" '<  `.___\_<|>_/___.' >' "".         #
 * #         | | :  `- \`.;`\ _ /`;.`/ - ` : | |       #
 * #         \  \ `_.   \_ __\ /__ _/   .-` /  /       #
 * #     =====`-.____`.___ \_____/___.-`___.-'===      #
 * #                       `=---='                     #
 * #     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   #
 * #                                                   #
 * #               佛祖保佑         永无BUG              #
 * #                                                   #
 * #####################################################
 */
public class WebUrl {


    public static String HTTP_T   = "http://t.dailian.iliexiang.com/";
//    public static String HTTP_T   = "https://dev.play.iliexiang.com/";
    public static String HTTP_DEV = "https://dev.play.iliexiang.com/";
    public static String HTTP_PRE = "https://pre.play.iliexiang.com/";
    public static String HTTP_WWW = "https://www.huowanes.com/";

//    public static String HTTP_H5_T   = getTH5Url();
//    public static String HTTP_H5_DEV = getDevH5Url();
//    public static String HTTP_H5_PRE = getPreH5Url();
//    public static String HTTP_H5_WWW = getWwwH5Url();

    public static String   HTTP_OSS     = "https://files.huowanes.com/";
    public static String[] HTTP_OSS_Arr = {"files.huowanes.com", "dianjing-oss.liexiang.net", "oss.huowanes.com", "aliyuncs.com", "oss-test.iliexiang.com"};

    //平时开发使用
//    public static String HTTP    = SharedPreferencesUtil.getPrefString(LXApplication.mInstance, LxKeys.WEB_URL, HTTP_DEV);
//    public static String HTTP_H5 = SharedPreferencesUtil.getPrefString(LXApplication.mInstance, LxKeys.WEB_URL_1, HTTP_H5_DEV);

    //正式打包使用
    public static String HTTP = HTTP_WWW;
//    public static String HTTP_H5 = HTTP_H5_WWW;


//    public static String HTTP    = HTTP_T;
//    public static String HTTP_H5 = HTTP_H5_T;

//    public static String HTTP = HTTP_DEV;
//    public static String HTTP_H5 = HTTP_H5_DEV;

//    public static String HTTP = HTTP_PRE;
//    public static String HTTP_H5 = HTTP_H5_PRE;


    //chat 聊天室
    public static String HALL                 = "api/dailian/home/hall";//hall
    public static String CHAT_ROOM_LIST                 = HTTP + "api_v2/chat/room/list";//房间列表
    public static String CHAT_RANK_LIST                 = HTTP + "api_v2/chat/rank/list";//榜单列表
    public static String CHAT_ROOM_JOIN                 = HTTP + "api_v2/chat/room/join";//加入房间
    public static String CHAT_ROOM_RANDOM_DISPATCH      = HTTP + "api_v2/chat/room/random_dispatch";//随机派单厅
    public static String CHAT_ROOM_INFO                 = HTTP + "api_v2/chat/room/info";//房间信息
    public static String CHAT_ROOM_JOIN_CHAT            = HTTP + "api_v2/chat/room/join_chat";//上麦
    public static String CHAT_ROOM_LEAVE_CHAT           = HTTP + "api_v2/chat/room/leave_chat";//下麦.踢人下麦
    public static String CHAT_ROOM_FORBID_CHAT          = HTTP + "api_v2/chat/room/forbid_chat";//禁麦
    public static String CHAT_ROOM_ALLOW_CHAT           = HTTP + "api_v2/chat/room/allow_chat";//开麦
    public static String CHAT_ROOM_PUSH_CHAT            = HTTP + "api_v2/chat/room/push_chat";//抱人上麦
    public static String CHAT_ROOM_SET_HOST             = HTTP + "api_v2/chat/room/set_host";//设为主持
    public static String CHAT_ROOM_CANCEL_HOST          = HTTP + "api_v2/chat/room/cancel_host";//取消主持
    public static String CHAT_ROOM_SET_MANAGER          = HTTP + "api_v2/chat/room/set_manager";//设为普通管理
    public static String CHAT_ROOM_CANCEL_MANAGER       = HTTP + "api_v2/chat/room/cancel_manager";//取消普通管理
    public static String CHAT_ROOM_KICK                 = HTTP + "api_v2/chat/room/kick";//踢出房间
    public static String CHAT_ROOM_CANCEL_FROZEN        = HTTP + "api_v2/chat/room/cancel_frozen";//取消封禁
    public static String CHAT_ROOM_DISMISS              = HTTP + "api_v2/chat/room/dismiss";//房间管理-解散房间
    public static String CHAT_ROOM_QUIT                 = HTTP + "api_v2/chat/room/quit";//退出房间
    public static String CHAT_ROOM_SUSPENSION           = HTTP + "api_v2/chat/room/suspension";//房间悬浮窗
    public static String CHAT_ROOM_USER                 = HTTP + "api_v2/chat/room/users";//房间管理-用户列表
    public static String CHAT_ROOM_REWARD_LIST          = HTTP + "api_v2/chat/room/reward_list";//房间管理-打赏
    public static String CHAT_ROOM_LOG                  = HTTP + "api_v2/chat/room/log";//房间管理-日志
    public static String CHAT_ROOM_MANAGER_LIST         = HTTP + "api_v2/chat/room/manager_list";//房间管理-管理员列表
    public static String CHAT_ROOM_FORBID_LIST          = HTTP + "api_v2/chat/room/forbid_list";//房间管理-封禁列表
    public static String CHAT_ROOM_INVITE               = HTTP + "api_v2/chat/room/invite";//邀请好友
    public static String CHAT_ROOM_INCOME_LIST          = HTTP + "api_v2/chat/room/income_list";//收入统计
    public static String CHAT_ROOM_REPORT               = HTTP + "api_v2/chat/room/report";//举报房间
    public static String CHAT_ROOM_ORDER_OVER           = HTTP + "api_v2/chat/room/dispatch_over";//完成派单
    public static String CHAT_ROOM_DISPATCH_ORDER       = HTTP + "api_v2/chat/room/dispatch_order";//派单
    public static String CHAT_ROOM_IN_CHECk             = HTTP + "api_v2/chat/room/in_check";//派单中心进入房间监测
    public static String CHAT_ROOM_ESTABLISH            = HTTP + "api_v2/chat/room/establish";//编辑房间
    public static String CHAT_GIFT_LIST                 = HTTP + "api_v2/chat/gift/list";//礼物列表
    public static String CHAT_GIFT_REWARD_IN_ROOM       = HTTP + "api_v2/chat/gift/reward_in_room";//聊天室内打赏礼物
    public static String CHAT_GIFT_REWARD_OUT_ROOM      = HTTP + "api_v2/chat/gift/reward_out_room";//聊天室外打赏礼物
    public static String CHAT_SETTING_INFO              = HTTP + "api_v2/chat/setting/info";//聊天室设置信息
    public static String CHAT_MUSIC_LISTS               = HTTP + "api_v2/chat/music/list";//聊天室背景音乐
    public static String CHAT_MUSIC_DELETE              = HTTP + "api_v2/chat/music/delete";//聊天室背景音乐删除
    public static String CHAT_ROOM_ENTER_QUEUE          = HTTP + "api_v2/chat/room/enter_queue";//聊天室 参加队列 [order:点单|audition:试音|male:男神|female:女神|join:参加]
    public static String CHAT_ROOM_CANCEL_QUEUE         = HTTP + "api_v2/chat/room/cancel_queue";//聊天室 取消队列
    public static String CHAT_ROOM_QUEUE_LIST           = HTTP + "api_v2/chat/room/queue_list";//聊天室 队列列表
    public static String CHAT_ROOM_CHANGE_MATCH_STATUS  = HTTP + "api_v2/chat/room/change_match_status";//聊天室配对-切换状态
    public static String CHAT_ROOM_CHOOSE               = HTTP + "api_v2/chat/room/choose";//聊天室配对-配对-选择
    public static String CHAT_ROOM_CANCEL_CHOOSE        = HTTP + "api_v2/chat/room/cancel_choose";//聊天室配对-配对-取消选择
    public static String CHAT_ROOM_SEQUENCE_CHARM       = HTTP + "api_v2/chat/room/sequence_charm";//聊天室 主持操作
    public static String CHAT_ROOM_SWITCH_PUBLIC_SCREEN = HTTP + "api_v2/chat/room/switch_public_screen";//管理-公屏开关
    public static String CHAT_ROOM_SWITCH_FREE_CHAT     = HTTP + "api_v2/chat/room/switch_free_chat";//麦位-自由上麦开关
    public static String CHAT_ROOM_SET_BACKGROUND       = HTTP + "api_v2/chat/room/set_background";//麦位-自由上麦开关
    public static String CHAT_ROOM_RANK                 = HTTP + "api_v2/chat/rank/room";//聊天室榜单
    public static String CHAT_GIFT_ROOM_NOTICE          = HTTP + "api_v2/chat/gift/room_notice";//打赏-发送飘屏
    public static String CHAT_ROOM_ANNOUNCE             = HTTP + "api_v2/chat/room/announce";//聊天室配对厅 公布
    public static String CHAT_ROOM_LOCK_SEQUENCE        = HTTP + "api_v2/chat/room/lock_sequence";//锁麦
    public static String CHAT_ROOM_UN_LOCK_SEQUENCE     = HTTP + "api_v2/chat/room/unlock_sequence";//解锁
    public static String CHAT_ROOM_SWITCH_COUNTDOWN     = HTTP + "api_v2/chat/room/switch_countdown";//主持操作-切换倒计时状态
    public static String CHAT_ROOM_SUPPLY_RANK          = HTTP + "api_v2/chat/supply/rank";//补给手气榜
    public static String CHAT_ROOM_SUPPLY_SELF_RECORD   = HTTP + "api_v2/chat/supply/self_record";//超级空投手气榜
    public static String CHAT_ROOM_CHANGE_SEQUENCE_TYPE = HTTP + "api_v2/chat/room/change_sequence_type";//修改麦位类型
    public static String CHAT_ROOM_USER_STATUS          = HTTP + "api_v2/chat/room/user_status";//im 获取是否在聊天室内
    public static String CHAT_RED_ENVELOP_ESTABLISH     = HTTP + "api_v2/chat/red_envelop/establish";//[2.19]发红包
    public static String CHAT_RED_ENVELOP_LISTS         = HTTP + "api_v2/chat/red_envelop/lists";//[2.19]红包-可领取列表
    public static String CHAT_RED_ENVELOP_OPEN          = HTTP + "api_v2/chat/red_envelop/open";//[2.19]红包-开红包
    public static String CHAT_RED_ENVELOP_GRAB          = HTTP + "api_v2/chat/red_envelop/grab";//[2.19]红包-抢红包
    public static String CHAT_ROOM_MY_ROOM_LIST         = HTTP + "api_v2/chat/my_room/list";//[2.19]我的房间、我的收藏、最近访问
    public static String CHAT_ROOM_COLLECT              = HTTP + "api_v2/chat/room/collect";//[2.19]收藏/取消收藏
    public static String CHAT_GIFT_RANK_LIST            = HTTP + "api_v2/chat/gift_rank/list";//[2.19]礼物榜
    public static String CHAT_ROOM_INCOME_DETAIL        = HTTP + "api_v2/chat/room/income_detail";//[2.19]收入统计-详细
    public static String CHAT_ROOM_GAME_LIST            = HTTP + "api_v2/chat/room/game_list";//[2.22]游戏厅列表接口
    public static String CHAT_CAR_LIST_JOIN             = HTTP + "api_v2/chat/car/list_join";//[2.22]列表加入车队
    public static String CHAT_CAR_JOIN                  = HTTP + "api_v2/chat/car/join";//[2.22]房间加入车队
    public static String CHAT_CAR_ESTABLISH             = HTTP + "api_v2/chat/car/establish";//[2.22]创建车队
    public static String CHAT_CAR_INFO                  = HTTP + "api_v2/chat/car/info";//[2.22]车队信息
    public static String CHAT_CAR_LIST                  = HTTP + "api_v2/chat/car/list";//[2.22]车队信息
    public static String CHAT_CAR_QUIT                  = HTTP + "api_v2/chat/car/quit";//[2.22]退出车队/退出车队
    public static String CHAT_CAR_DRIVE                 = HTTP + "api_v2/chat/car/drive";//[2.22]发车
    public static String CHAT_CAR_DISMISS               = HTTP + "api_v2/chat/car/dismiss";//[2.22]解散车队
    public static String CHAT_GAME_ROOM_SUMMON          = HTTP + "api_v2/chat/game_room/summon";//[2.22]召唤队友通知
    public static String CHAT_HOST_OPERATION            = HTTP + "api_v2/chat/room/host_operate";//[2.23]主持人操作
    public static String CHAT_GUARD_LISTS               = HTTP + "api_v2/chat/guard/lists";//[2.23]获取守护、守护团数据
    public static String CHAT_GUARD_JOIN                = HTTP + "api_v2/chat/guard/join";//[2.23]立即加入守护团
    public static String CHAT_GUARD_PAY                 = HTTP + "api_v2/chat/guard/pay";//[2.23]守护购买、续费
    public static String CHAT_MUSIC_ADD_TO_MY           = HTTP + "api_v2/chat/music/add_to_my";//[2.23]添加到我的音乐
    public static String CHAT_MUSIC_PLAY_NUM            = HTTP + "api_v2/chat/music/play_num";//[2.23]音乐播放次数
    public static String CHAT_PK_OPERATION              = HTTP + "api_v2/chat/pk/operation";//[2.24]操作台操作
    public static String CHAT_SEQUENCE_PRIVILEGE        = HTTP + "api_v2/chat/room/privileges";//[2.24]房间内权限
    public static String CHAT_SHARE_ROOM                = HTTP + "api_v2/chat/room/share_room";//[2.26]分享聊天室
    public static String CHAT_SUPPLY_SUPER_SUPPLY       = HTTP + "api_v2/chat/supply/super_supply";//[2.27]超级空投信息
    public static String CHAT_SUPPLY_OPEN               = HTTP + "api_v2/chat/supply/open";//[2.27]开启超级空投
    public static String CHAT_GOLDEN_EGG_INFO           = HTTP + "api_v2/chat/golden_egg/info";//[2.27.1]砸金蛋信息
    public static String CHAT_GOLDEN_EGG_OPEN           = HTTP + "api_v2/chat/golden_egg/open";//[2.27.1]砸金蛋
    public static String CHAT_GOLDEN_EGG_SELF_RECORD    = HTTP + "api_v2/chat/golden_egg/self_record";//[2.27.1]个人开启记录
    public static String CHAT_USER_GOD_RANK             = HTTP + "api_v2/user/god/rank";//[2.30.0]大神榜榜单列表
    public static String CHAT_USER_GOD_SCORE_RANK       = HTTP + "api_v2/user/god/score_rank";//[2.30.0]大神分榜单列表
    public static String CHAT_ROOM_HOME_RANDOM          = HTTP + "api_v2/chat/room/home_random";//[3.0.0]首页聊一聊


    //商城
    public static String CHAT_SHOP_SEAT_SAVE         = HTTP + "api_v2/shop/seat/save";//商城-座位框-保存
    public static String CHAT_SHOP_SEAT_PAY          = HTTP + "api_v2/shop/seat/pay";//商城-座位框-购买
    public static String CHAT_SHOP_MOUNT_PAY         = HTTP + "api_v2/shop/mount/pay";//商城-坐骑-购买
    public static String CHAT_SHOP_NOBLE_LIST        = HTTP + "api_v2/shop/noble/lists_v2";//商城-贵族-列表
    public static String CHAT_SHOP_NOBLE_PAY         = HTTP + "api_v2/shop/noble/pay";//商城-贵族-购买
    public static String CHAT_SHOP_BAG_LISTS_V2      = HTTP + "api_v2/shop/bag/lists_v2";//我的-背包-列表
    public static String CHAT_SHOP_BAG_USE           = HTTP + "api_v2/shop/bag/use";//商城-背包-使用.赠送
    public static String CHAT_DOWNLOAD_RESOURCES     = HTTP + "api_v2/chat/resource/download";//资源下载
    public static String CHAT_SHOP_NOBLE_LIMITS_LIST = HTTP + "api_v2/shop/noble_set/list";//贵族权限列表
    public static String CHAT_SHOP_NOBLE_SET         = HTTP + "api_v2/shop/noble_set/edit";//设置贵族权限
    public static String CHAT_SHOP_NOBLE_CHANGE      = HTTP + "api_v2/shop/noble/change";//贵族切换
    public static String CHAT_SHOP_SEAT_TAGS         = HTTP + "api_v2/shop/seat/tags";//座位框标签列表
    public static String CHAT_SHOP_SEAT_LISTS_V2     = HTTP + "api_v2/shop/seat/lists_v2";//座位框列表V2
    public static String CHAT_SHOP_MOUNT_TAGS        = HTTP + "api_v2/shop/mount/tags";// 坐骑标签列表
    public static String CHAT_SHOP_MOUNT_LISTS       = HTTP + "api_v2/shop/mount/lists";//坐骑列表
    public static String CHAT_SHOP_MOUNT_SAVE        = HTTP + "api_v2/shop/mount/save";//商城-坐骑-保存

    //公会
    public static String GUIDE_INVITE_JOIN             = HTTP + "api_v2/guild/invite/join";//公会邀请-加入
    public static String GUIDE_INVITE_ALLOCATION       = HTTP + "api_v2/guild/invite/allocation";//公会分成-变更
    public static String GUIDE_INVITE_JOIN_CHECK       = HTTP + "api_v2/guild/invite/join_check";//公会邀请-加入 监测
    public static String GUIDE_INVITE_ALLOCATION_CHECK = HTTP + "api_v2/guild/invite/allocation_check";//公会分成-变更 监测
    public static String GUIDE_RECOMMEND_LIST          = HTTP + "api_v2/guild/recommend/list";//公会推荐列表
    public static String GUIDE_RECOMMEND_JOIN          = HTTP + "api_v2/guild/user/join";//公会推荐加入
    public static String GUIDE_MY                      = HTTP + "api_v2/guild/user/my";//我的公会
    public static String GUIDE_QUIT_APPLY              = HTTP + "api_v2/guild/user/quit_apply";//退出公会

    //finance
    public static String FINANCE_CASH_LIST            = HTTP + "api_v1/finance/cash/lists";
    public static String FINANCE_CASH_CHARM_LIST      = HTTP + "api_v2/finance/cash_charm/lists";//魅力值 体现列表
    public static String FINANCE_CHARGE_ESTABLISH     = HTTP + "api_v1/finance/charge/establish";//
    public static String FINANCE_CASH_ESTABLISH       = HTTP + "api_v1/finance/cash/establish";//伙币提现
    public static String FINANCE_CASH_CHARM_ESTABLISH = HTTP + "api_v2/finance/cash_charm/establish";//魅力值提现
    public static String FINANCE_SYNC_ALIPAY          = HTTP + "api_v1/finance/sync/alipay";//支付宝充值后的校验
    public static String FINANCE_SYNC_WX              = HTTP + "api_v1/finance/sync/wx";//微信充值后的校验
    public static String FINANCE_MONEY_CHECK          = HTTP + "api_v1/finance/money/check";//支付订单监测
    public static String FINANCE_BAND_ESTABLISH_V2    = HTTP + "api_v2/finance/bank/establish";//更改体现账号
    public static String FINANCE_BAND_LISTS_V2        = HTTP + "api_v2/finance/bank/lists";//体现账号
    public static String FINANCE_RECORD_BALANCE       = HTTP + "api_v2/finance/record/balance";//资金-伙币流水
    public static String FINANCE_RECORD_MONEY         = HTTP + "api_v2/finance/record/money";//资金-伙币收人流水

    //utils
    public static String UTIL_AREA_CODE           = HTTP + "api_v1/area/code";
    public static String UTIL_CAPTCHA_SEND        = HTTP + "api_v1/system/captcha/send";
    public static String UTIL_CAPTCHA_VERIFY_CODE = HTTP + "api_v1/system/captcha/verify_code";
    public static String UTIL_IMAGE_UPLOAD        = HTTP + "api_v1/system/image/upload";
    public static String UTIL_SYSTEM_INFO         = HTTP + "api_v1/system/core/info";//系统信息
    public static String UTIL_STS_TEMP_OSS        = HTTP + "api_v1/system/sts/temp_oss";//oss临时token
    public static String PAM_AUTH_RESET_PASSWORD  = HTTP + "api_v1/system/auth/reset_password";
    public static String PAM_BIND_NEW_PASSPORT    = HTTP + "api_v1/system/bind/new_passport";
    public static String SITE_HOME_BANNER         = HTTP + "api_v2/site/home/banner";
    public static String SITE_NEED_TOKEN          = HTTP + "api_v2/site/app/need_token_pages";

    //user
    public static String USER_APPROVE_PLAY          = HTTP + "api_v2/user/approve/play";//[2.21.0]陪玩中心
    public static String USER_APPROVE_LIST          = HTTP + "api_v2/user/approve/list";//认证游戏
    public static String USER_HUNTER_STATUS_V2      = HTTP + "api_v2/user/approve/status";//认证状态
    public static String USER_APPROVE_MODIFY_AVATAR = HTTP + "api_v2/user/approve/avatar";//修改认证头像
    public static String USER_APPROVE_CHILD         = HTTP + "api_v2/user/approve/chid";//身份证上传
    public static String USER_APPROVE_DETAIL        = HTTP + "api_v2/user/approve/detail";//用户认证需要的资料等
    public static String USER_APPROVE_DETAIL_EDIT   = HTTP + "api_v2/user/approve/detail_edit";//用户编辑资料:之前填写过的资料.以及需要的认证条件等
    public static String USER_APPROVE_ABILITY_V2    = HTTP + "api_v2/user/approve/ability";//游戏实力认证
    public static String USER_APPROVE_EDIT          = HTTP + "api_v2/user/approve/edit";//修改认证资料
    public static String USER_APPROVE_SET_TIME      = HTTP + "api_v2/user/approve/set_time";//认证-设置接单周期
    public static String USER_APPROVE_MY_BOSS       = HTTP + "api_v2/user/approve/my_boss";//我的老板
    public static String USER_APPROVE_FIND_BOSS     = HTTP + "api_v2/user/approve/boss";//发现老板


    public static String USER_PROFILE_MODIFY           = HTTP + "api_v1/user/profile/modify";//编辑个人资料
    public static String USER_RELATION_DO              = HTTP + "api_v1/user/relation/do";//关注/取消关注
    public static String USER_RELATION_LISTS           = HTTP + "api_v1/user/relation/lists";//关系列表
    public static String USER_PROFILE_RETURN_BOND      = HTTP + "api_v2/user/approve/cancel";//取消认证
    public static String USER_PROFILE_IS_BIND          = HTTP + "api_v1/user/profile/is_bind";//是否绑定QQ或者是微信
    public static String USER_REGISTER_ALI_PUSH        = HTTP + "api_v1/user/push/register_ali";//注册阿里推送
    public static String USER_PROFILE_LOGOUT           = HTTP + "api_v2/user/profile/logout";//退出登录(注销阿里推送,退出聊天室)
    public static String USER_WS_TOKEN                 = HTTP + "api_v1/user/ws/token";//web socket 测试
    public static String USER_PROFILE_UNBIND           = HTTP + "api_v1/system/bind/cancel";//解绑QQ或者是微信
    public static String USER_AUTH_LOGIN               = HTTP + "api_v2/user/profile/login";
    public static String USER_PROFILE_REGISTER         = HTTP + "api_v2/user/profile/register";//注册资料
    public static String USER_PROFILE_DETAIL_V2        = HTTP + "api_v2/user/profile/detail";//个人资料
    public static String USER_APPROVE_BOND_STATUS      = HTTP + "api_v2/user/approve/bond_status";//获取用户保证金身份状态
    public static String USER_APPROVE_BOND_V2          = HTTP + "api_v2/user/approve/bond";//保证金
    public static String USER_APPROVE_SET_PRICE        = HTTP + "api_v2/user/approve/set_price";//设置娱乐的价格
    public static String USER_GOD_HISTORY_V2           = HTTP + "api_v2/user/god/history";//大神中心-历史分数（大神分）
    public static String USER_PROFILE_PICTURE_V2       = HTTP + "api_v2/user/profile/picture";//照片墙列表
    public static String USER_APPROVE_SET_ACTIVITY     = HTTP + "api_v2/user/approve/set_activity";//设置活动
    public static String USER_APPROVE_GET_ACTIVITY     = HTTP + "api_v2/user/approve/get_activity";//获取活动信息
    public static String USER_PROFILE_ADD_SEARCH_V2    = HTTP + "api_v2/user/profile/search";//搜索好友
    public static String USER_PROFILE_COMMENTS_V2      = HTTP + "api_v2/user/profile/comments";//评价列表
    public static String USER_PROFILE_REPLY            = HTTP + "api_v2/user/profile/reply";//回复评价
    public static String USER_PROFILE_RETURN_SHORT     = HTTP + "api_v2/user/profile/return_short";//短语列表
    public static String USER_PROFILE_SOCIALITE_LOGIN  = HTTP + "api_v2/user/profile/socialite_login";//社会化登录
    public static String USER_PROFILE_SET_SHORT        = HTTP + "api_v2/user/profile/set_short";//短语列表
    public static String USER_PUNISH_PAY_FINE          = HTTP + "api_v2/user/punish/pay_fine";//支付罚款
    public static String USER_PUNISH_FINE_LIST         = HTTP + "api_v2/user/punish/fine_lists";//罚款列表
    public static String USER_VISIT_VIEW               = HTTP + "api_v2/user/visit/view";//足迹
    public static String USER_VISIT_CLEAN              = HTTP + "api_v2/user/visit/clean";//清空足迹
    public static String USER_BAN_DO                   = HTTP + "api_v2/user/ban/do";//拉黑 取消拉黑
    public static String USER_BAN_LISTS                = HTTP + "api_v2/user/ban/lists";//拉黑列表
    public static String USER_BAN_STATUS               = HTTP + "api_v2/user/ban/status";//查询用户是否在我的黑名单中
    public static String USER_PROFILE_REPORT           = HTTP + "api_v2/user/profile/report";//举报用户
    public static String USER_PROFILE_ACTIVE           = HTTP + "api_v2/user/profile/active";//用户活跃度
    public static String USER_PROFILE_SKILL            = HTTP + "api_v2/user/profile/skill";//用户技能
    public static String USER_VIP_SET_INVISIBLE        = HTTP + "api_v2/user/vip/set_invisible"; //设置隐身
    public static String USER_USER_SET_INFO            = HTTP + "api_v2/user/user_set/info";//获取消息通知状态
    public static String USER_USER_SET_INFO_STRANGER   = HTTP + "api_v2/user/user_set/stranger";//设置陌生人消息
    public static String USER_USER_SET_INFO_HOST_START = HTTP + "api_v2/user/user_set/accept_host_start";//设置接收主播开播提醒
    public static String USER_USER_SET_SET             = HTTP + "api_v2/user/user_set/set";//修改消息通知状态
    public static String USER_PLAY_LIST_V2             = HTTP + "api_v2/user/play/lists_v2";//品类列表
    public static String USER_VIP_SET_BADGE            = HTTP + "api_v2/user/vip/set_badge";//修改徽章
    public static String USER_PROFILE_ESTABLISH_WALL   = HTTP + "api_v2/user/profile/establish_wall";//照片墙提交
    public static String USER_USER_SET_MOBILE          = HTTP + "api_v2/user/user_set/mobile";//2.9.0 更改通知手机号
    public static String USER_MATCH_ORDER              = HTTP + "api_v2/user/profile/match_order";//查询是否有匹配的上分单子
    public static String USER_PROFILE_ENVELOP_WEALTH   = HTTP + "api_v2/user/profile/wealth";//[2.19]获取用户资金
    public static String USER_PROFILE_GIFT             = HTTP + "api_v2/user/profile/gift";//[2.19]礼物墙列表
    public static String USER_PROFILE_POPUP_INFO       = HTTP + "api_v2/user/profile/popup_info";//[2.24.1]个人资料
    public static String USER_PROFILE_TOURIST          = HTTP + "api_v2/user/profile/tourist";//游客资料
    public static String USER_SET_GEO_INVISIBLE        = HTTP + "api_v2/user/user_set/geo_invisible";//[2.25]隐藏用户定位
    public static String USER_COUNTRY                  = HTTP + "api_v2/user/profile/country";//[2.25]国家码
    public static String USER_VIP_SETTING_INFO         = HTTP + "api_v2/user/vip/setting_info";//[2.25]vip设置信息接口
    public static String USER_VISIT_RECORD             = HTTP + "api_v2/user/visit/record";//[2.25]访问足迹
    public static String USER_PROFILE_SHARE            = HTTP + "api_v2/user/profile/share";//[2.26]分享个人主页
    public static String USER_USER_POSTER_INFO         = HTTP + "api_v2/user/user_poster/info";//[2.26]生成海报资料
    public static String USER_USER_POSTER_DOWNLOAD     = HTTP + "api_v2/user/user_poster/download";//[2.26]海报下载
    public static String USER_CATEGORY_INFO            = HTTP + "api_v2/user/category/info";//个人品类页用户信息
    public static String USER_CATEGORY_RECOMMEND_USER  = HTTP + "api_v2/user/category/recommend_user";//个人品类页推荐用户列表
    public static String USER_PROFILE_GEOGRAPHY        = HTTP + "api_v2/user/profile/geography";//设置用户地理位置

    public static String ORDER_COUPON_LISTS               = HTTP + "api_v2/order/coupon/lists";
    //order
    public static String ORDER_BOSS_LIST                  = HTTP + "api_v1/order/boss/lists";//老板-普通-列表
    public static String ORDER_HUNTER_LIST                = HTTP + "api_v1/order/hunter/lists";//大神-普通订单-列表
    public static String ORDER_BOSS_ESTABLISH             = HTTP + "api_v1/order/boss/establish";
    public static String ORDER_HUNTER_LISTEN              = HTTP + "api_v1/order/hunter/listen";//听单
    public static String ORDER_HUNTER_CANCEL_LISTEN       = HTTP + "api_v1/order/hunter/cancel_listen";//取消听单
    public static String ORDER_COMMENT_DO                 = HTTP + "api_v1/order/boss/comment";//评价
    public static String ORDER_BOSS_DELETE                = HTTP + "api_v1/order/boss/delete";//老板删除订单
    public static String ORDER_BOSS_ONLY                  = HTTP + "api_v2/order/boss/appoint";//专属单/再来一单
    public static String ORDER_HUNTER_DISPATCH_SET        = HTTP + "api_v2/order/hunter/dispatch_set";//派单设置信息
    public static String ORDER_HUNTER_DISPATCH_CANCEL     = HTTP + "api_v2/order/hunter/dispatch_cancel";//派单设置取消
    public static String ORDER_HUNTER_LISTENS_V2          = HTTP + "api_v2/order/hunter/listens";//网络请求当前的订单情况
    public static String ORDER_HUNTER_DISPATCH_LISTENS_V2 = HTTP + "api_v2/order/hunter/dispatch_listens";//网络请求当前的派单情况
    public static String ORDER_COMMON_ORDER_NO            = HTTP + "api_v2/order/common/order_no";//根据群id获取订单号
    public static String ORDER_GAME_APPEND                = HTTP + "api_v2/order/game/append";//游戏信息-追加
    public static String ORDER_CATEGORY_LIST              = HTTP + "api_v2/user/category/select";//品类页-筛选框列表
    public static String ORDER_HUNTER_CANCEL_V2           = HTTP + "api_v2/order/hunter/cancel";//猎手取消订单
    public static String ORDER_BOSS_CANCEL_V2             = HTTP + "api_v2/order/boss/cancel";//老板取消订单
    public static String ORDER_BOSS_SETTLE_V2             = HTTP + "api_v2/order/boss/settle";//老板结算
    public static String ORDER_COMMON_CHAT_V2             = HTTP + "api_v2/order/common/chat";//聊天记录
    public static String ORDER_COMMON_DETAIL_V2           = HTTP + "api_v2/order/common/detail";//订单详情
    public static String ORDER_HUNTER_START_V2            = HTTP + "api_v2/order/hunter/start";//开始截图
    public static String ORDER_HUNTER_ROB_V2              = HTTP + "api_v2/order/hunter/rob";//抢单
    public static String ORDER_COMMON_COMPLAINT_V2        = HTTP + "api_v2/order/common/complaint";//投诉 双向
    public static String ORDER_HUNTER_RETURN_TAGS         = HTTP + "api_v2/order/hunter/return_tags";//获取评价标签
    public static String ORDER_HUNTER_EXAMINE_V2_V3       = HTTP + "api_v2/order/hunter/examine_v3";//普通单提交结果
    public static String ORDER_HUNTER_CHECK_APPOINTMENT   = HTTP + "api_v2/order/hunter/check_appointment";//检查预约
    public static String ORDER_GAME_CONDITION             = HTTP + "api_v2/order/game/order_condition";//个性化匹配条件
    public static String ORDER_GAME_HOME                  = HTTP + "api_v2/order/game/home";//首页-品类-banner等数据
    public static String ORDER_GAME_MORE                  = HTTP + "api_v2/order/game/more";//首页-品类-更多游戏
    public static String ORDER_HUNTER_LISTENED            = HTTP + "api_v2/order/hunter/listened";//查询是否预约
    public static String ORDER_GAME_BANNER                = HTTP + "api_v2/order/game/game_banner";//banner
    public static String SITE_HOME_LISTS                  = HTTP + "api_v2/site/home/lists";//首页-用户列表
    public static String SITE_HOME_POPUP                  = HTTP + "api_v2/site/home/popup";//首页-弹窗
    public static String ORDER_HUNTER_LISTEN_COUNT        = HTTP + "api_v2/order/hunter/listen_count";//可接手订单数量
    public static String ORDER_MATCH_RESPONSE             = HTTP + "api_v2/order/match/response";//[2.29.0]匹配订单-打手响应
    public static String ORDER_MATCH_ESTABLISH            = HTTP + "api_v2/order/match/establish";//[2.29.0]娱乐匹配-创建订单
    public static String ORDER_MATCH_GAMES                = HTTP + "api_v2/order/match/games";//[2.29.0]娱乐匹配-游戏列表
    public static String ORDER_MATCH_HUNTERS              = HTTP + "api_v2/order/match/hunters";//[2.29.0]娱乐匹配-响应打手列表接口
    public static String ORDER_MATCH_DELETE               = HTTP + "api_v2/order/match/delete";//[2.29.0]娱乐匹配-取消匹配
    public static String ORDER_MATCH_CHOOSE               = HTTP + "api_v2/order/match/choose";//[2.29.0]娱乐匹配-匹配支付
    public static String ORDER_FIRST_ORDER_ESTABLISH      = HTTP + "api_v2/order/first_order/establish";//[2.30.0]娱乐匹配-1元匹配支付
    public static String ORDER_COMMON_CANCEL_COMPLAINT    = HTTP + "api_v2/order/common/cancel_complaint";//[2.30.0]取消投诉-普通订单


    //feature 个性单
    public static String FEATURE_GOODS_USER_LISTS        = HTTP + "api_v2/feature/goods/user_lists";//自己的商品列表(删除 上架)，淘服务
    public static String FEATURE_GOODS_LISTS             = HTTP + "api_v2/feature/goods/lists";//商品列表  用户看到的
    public static String FEATURE_GOODS_ESTABLISH         = HTTP + "api_v2/feature/goods/establish";//创建商品
    public static String FEATURE_GOODS_OPERATION         = HTTP + "api_v2/feature/goods/operation";//操作商品
    public static String FEATURE_GOODS_INFO              = HTTP + "api_v2/feature/goods/goods_info";//个性单 商品详情
    public static String FEATURE_BOSS_ESTABLISH          = HTTP + "api_v2/feature/boss/establish";//个性单 下单
    public static String FEATURE_HUNTER_HANDLE           = HTTP + "api_v2/feature/hunter/handle";//接单 个性订单
    public static String FEATURE_COMMENT_DETAIL          = HTTP + "api_v2/feature/common/detail";//订单详情
    public static String FEATURE_HUNTER_LISTS            = HTTP + "api_v2/feature/hunter/lists";//猎手订单列表
    public static String FEATURE_BOSS_LISTS              = HTTP + "api_v2/feature/boss/lists";//老板订单列表
    public static String FEATURE_HUNTER_START            = HTTP + "api_v2/feature/hunter/start";//上传首图
    public static String FEATURE_HUNTER_EXAMINE          = HTTP + "api_v2/feature/hunter/examine";//上传战绩
    public static String FEATURE_BOSS_CANCEL             = HTTP + "api_v2/feature/boss/cancel";//老板取消订单
    public static String FEATURE_BOSS_SETTLE             = HTTP + "api_v2/feature/boss/settle";//老板结算
    public static String FEATURE_HUNTER_CANCEL           = HTTP + "api_v2/feature/hunter/cancel";//老板取消订单
    public static String FEATURE_COMMENT_COMPLAINT       = HTTP + "api_v2/feature/common/complaint";//投诉
    public static String FEATURE_COMMENT_CHAT            = HTTP + "api_v2/feature/common/chat";//聊天记录
    public static String FEATURE_BOSS_COMMENT            = HTTP + "api_v2/feature/boss/comment";//评价
    public static String FEATURE_GOODS_TAGS              = HTTP + "api_v2/feature/goods/tags";//评价-标签
    public static String FEATURE_COMMON_CANCEL_COMPLAINT = HTTP + "api_v2/feature/common/cancel_complaint";//[2.30.0]取消投诉-淘服务订单


    //圈子
    public static String MOMENTS_POST_ESTABLISH      = HTTP + "api_v2/moments/post/establish";//发表动态
    public static String MOMENTS_POST_LOTTERY_DETAIL = HTTP + "api_v2/moments/post/lottery_detail";//抽奖详情
    public static String MOMENTS_POST_LIST           = HTTP + "api_v2/moments/post/list";//帖子列表
    public static String MOMENTS_POST_DETAIL         = HTTP + "api_v2/moments/post/detail";//帖子详情
    public static String MOMENTS_POST_LIKED          = HTTP + "api_v2/moments/post/liked";//点赞
    public static String MOMENTS_POST_TRANSMIT       = HTTP + "api_v2/moments/post/transmit";//转发
    public static String MOMENTS_GROUP_LIST          = HTTP + "api_v2/moments/group/list";//圈子话题列表
    public static String MOMENTS_GROUP_SAVE          = HTTP + "api_v2/moments/group/save";//用户修改我的圈子
    public static String MOMENTS_GROUP_AD            = HTTP + "api_v2/moments/group/ad";//指定圈子下的广告列表
    public static String USER_PROFILE_REECOMMEND     = HTTP + "api_v2/user/profile/recommend";//推荐用户
    public static String MOMENTS_GROUP_TREE          = HTTP + "api_v2/moments/group/tree";//话题树
    public static String MOMENTS_GROUP_SETTING_INFO  = HTTP + "api_v2/moments/group/setting_info";//系统信息
    public static String MOMENTS_COMMENT_ESTABLISH   = HTTP + "api_v2/moments/comment/establish";//评论
    public static String MOMENTS_COMMENT_LISTS       = HTTP + "api_v2/moments/comment/lists";//评论详情
    public static String MOMENTS_COMMENT_REPLY_LISTS = HTTP + "api_v2/moments/comment/reply_lists";//评论详情
    public static String MOMENTS_COMMENT_LIKED       = HTTP + "api_v2/moments/comment/liked";//评论点赞
    public static String MOMENTS_COMMENT_DELETE      = HTTP + "api_v2/moments/comment/delete";//评论删除
    public static String MOMENTS_COMMENT_POST_REPORT = HTTP + "api_v2/moments/post/report";//举报帖子
    public static String MOMENTS_POST_USER           = HTTP + "api_v2/moments/post/user";//用户动态-自己的帖子列表
    public static String MOMENTS_TOPIC_INFO          = HTTP + "api_v2/moments/topic/info";//话题详情
    public static String MOMENTS_TOPIC_CONCERN       = HTTP + "api_v2/moments/topic/concern";//话题详情
    public static String MOMENTS_POST_SEARCH         = HTTP + "api_v2/moments/post/search";//话题搜索
    public static String MOMENTS_POST_REWARD_LIST    = HTTP + "api_v2/moments/post/reward_list";//帖子内打赏记录列表接口
    public static String MOMENTS_POST_DEL            = HTTP + "api_v2/moments/post/del";//用户删除动态
    public static String MOMENTS_POST_READ           = HTTP + "api_v2/moments/post/read";//帖子阅读量
    public static String MOMENTS_POST_SHARE          = HTTP + "api_v2/moments/post/share";//[2.26.0]分享帖子
    public static String MOMENTS_ORDER_CHECK         = HTTP + "api_v2/moments/order/check";//[2.26.0]检查技能


    //陪玩中心
//    public static String ORDER_HUNTER_LISTEN_SET_ALL = HTTP + "api_v2/order/hunter/listen_set_all";//[2.21.0]派单设置列表
//    public static String USER_APPROVE_SERVERS        = HTTP + "api_v2/user/approve/servers";//[2.29.0]接单区服
//    public static String USER_APPROVE_DANS           = HTTP + "api_v2/user/approve/dans";//[2.29.0]接单区服
//
//    //帮助中心
//    public static String USER_PROFILE_HELP    = HTTP + "mobile/site/page/help";//帮助-接口
//    public static String USER_PROFILE_HELP_h5 = HTTP_H5 + "page/g/help_list";//帮助-h5
//    //版本更新
//    public static String SUNDRY_HOME_VERSION  = HTTP + "api_v1/site/android/version";//监测新版本
//    public static String SITE_APP_LOG         = HTTP + "api_v2/site/app/log";//APP错误日志统计
//    public static String FIRST_OPEN_APP       = HTTP + "api_v2/site/app/first_open";//首次打开app,快手监测
//    public static String APP_WEIBO_CALLBACK   = HTTP + "api_v2/site/app/wb_callback";//微博回调地址
//
//    //H5
//    public static String H5_ORDER_PROFILE_ABOUT       = HTTP_H5 + "page/g/about";//关于我们
//    public static String H5_USER_PROTOCOL             = HTTP_H5 + "page/g/protocol";//用户协议
//    public static String H5_USER_DISCLAIMER           = HTTP_H5 + "page/g/disclaimer";//免责声明
//    public static String H5_USER_AGREEMENT            = HTTP_H5 + "page/user/hunter_protocl";//猎手协议
//    public static String H5_USER_SCORE                = HTTP_H5 + "page/order/score";//订单-上分说明
//    public static String H5_USER_PLAY                 = HTTP_H5 + "page/order/play";//订单-陪玩说明
//    public static String H5_SUNDRY_FEATURE            = HTTP_H5 + "page/feature/explain";//订单-淘服务说明
//    public static String H5_USER_PRIZE_RULE           = HTTP_H5 + "act/lottery/explain";//抽奖活动公告
//    public static String H5_ACTIVITY_LISTS            = HTTP_H5 + "act/list";//活动中心
//    public static String H5_USER_VIP_CENTER           = HTTP_H5 + "user/vipnew/center";//会员中心
//    public static String H5_USER_GOD_SCORE            = HTTP_H5 + "user/god_score";//大神分
//    public static String H5_PAGE_GOD_GOD_EXPLAIN      = HTTP_H5 + "page/god/god_explain";//大神分说明
//    public static String H5_USER_VIP_TASK             = HTTP_H5 + "user/vip/task";//会员任务
//    public static String H5_USER_VIP_EXPLAIN          = HTTP_H5 + "user/vipnew/explain";//会员说明
//    public static String H5_CHARGE_HELP               = HTTP_H5 + "page/finance/charge_explain";//账户充值说明
//    public static String H5_DISPATCH_EXPLAIN          = HTTP_H5 + "page/order/dispatch_explain";//抢单 派单说明
//    public static String H5_SITE_USER_INVITE          = HTTP_H5 + "user/invite";//分享赚钱
//    public static String H5_ACT_FIRST_ORDER           = HTTP_H5 + "act/first_order";//首单礼包
//    public static String H5_ACT_HOW_APPOINT_GOD       = HTTP_H5 + "act/how_appoint_god";//如何约玩大神
//    public static String H5_ACT_HOW_BECOME_GOD        = HTTP_H5 + "act/how_become_god";//如何成为大神
//    public static String H5_ACT_TEACH_YOU_PLAY_HUOWAN = HTTP_H5 + "act/teach_you_play_huowan";//教你玩转
//    public static String H5_ACT_SIGN_NEW_INDEX        = HTTP_H5 + "act/sign_new/index";//签到


    private WebUrl() {
    }

    private static WebUrl instance;

    public static WebUrl get() {
        if (instance == null) {
            synchronized (WebUrl.class) {
                if (instance == null) {
                    instance = new WebUrl();
                }
            }
        }
        return instance;
    }

//
//    public static String getWwwH5Url() {
//
//        if (BuildConfig.FLAVOR.equals(LxKeys.BuildConfig_FLAVOR_MX) || BuildConfig.FLAVOR.equals(LxKeys.BuildConfig_FLAVOR_MX_T)) {
//            return "https://m.mixinkeji.net/";
//        } else {
//            return "https://m.huowanes.com/";
//        }
//    }
//
//    public static String getTH5Url() {
//
//        if (BuildConfig.FLAVOR.equals(LxKeys.BuildConfig_FLAVOR_MX) || BuildConfig.FLAVOR.equals(LxKeys.BuildConfig_FLAVOR_MX_T)) {
//            return "http://t.mixin-m.iliexiang.com/";
//        } else {
//            return "http://t.play-m.iliexiang.com/";
//        }
//    }
//
//    public static String getDevH5Url() {
//
//        if (BuildConfig.FLAVOR.equals(LxKeys.BuildConfig_FLAVOR_MX) || BuildConfig.FLAVOR.equals(LxKeys.BuildConfig_FLAVOR_MX_T)) {
//            return "http://dev.mixin-m.iliexiang.com/";
//        } else {
//            return "http://dev.play-m.iliexiang.com/";
//        }
//    }
//
//    public static String getPreH5Url() {
//
//        if (BuildConfig.FLAVOR.equals(LxKeys.BuildConfig_FLAVOR_MX) || BuildConfig.FLAVOR.equals(LxKeys.BuildConfig_FLAVOR_MX_T)) {
//            return "http://pre.mixin-m.iliexiang.com/";
//        } else {
//            return "http://pre.play-m.iliexiang.com/";
//        }
//    }

}
