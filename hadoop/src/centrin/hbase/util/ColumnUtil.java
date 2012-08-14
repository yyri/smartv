package centrin.hbase.util;

/**
 * 数据库列常量类
 * 
 * @author shengyidong
 * 
 */
public final class ColumnUtil {

	/**
	 * 数据表列信息
	 */
	public final static byte[] CF = "cf_smartv".getBytes();// 路径
	public final static byte[] PATH = "path".getBytes();// 路径
	public final static byte[] FILENAME = "filename".getBytes();// 文件名
	public final static byte[] DEPARTMENT = "department".getBytes();// 部门
	public final static byte[] CUSTOMERNO = "customerNo".getBytes();// 客户号
	public final static byte[] PKGNO = "pkgno".getBytes();// 包编号
	public final static byte[] PKGPATH = "pkgpath".getBytes();// 包路径
	public final static byte[] PKGNAME = "pkgname".getBytes();// 包名称
	public final static byte[] UPLOADDATE = "uploadDate".getBytes();// 上传日期
	public final static byte[] COMPRESSIONDATE = "compressionDate".getBytes();// 打包日期
	public final static byte[] ADJUSTTODATE = "adjusttoDate".getBytes();// 调听日期
	public final static byte[] SOUNDMESSAGE = "soundMessage".getBytes();// 语音信息
	public final static byte[] KEYWORDTIMEALL = "keywordTimeAll".getBytes();// 关键字出现的时间
	public final static byte[] KEYWORDTIMEQISU = "keywordTimeQisu".getBytes();// 关键字"起诉"出现的时间
	public final static byte[] KEYWORDTIMEBUHELI = "keywordTimeBuheli"
			.getBytes();// 关键字"不合理"出现的时间
	public final static byte[] KEYWORDTIMEYIJIAN = "keywordTimeYijian"
			.getBytes();// 关键字"意见"出现的时间
	public final static byte[] KEYWORDTIMEFUWU = "keywordTimeFuwu".getBytes();// 关键字"服务"出现的时间
	public final static byte[] KEYWORDTIMETAIDU = "keywordTimeTaidu".getBytes();// 关键字"态度"出现的时间
	public final static byte[] KEYWORDTIMEYOUXIAOQI = "keywordTimeYouxiaoqi"
			.getBytes();// 关键字"有效期"出现的时间
	public final static byte[] KEYWORDTIMEFEIBENREN = "keywordTimeFeibenren"
			.getBytes();// 关键字"非本人"出现的时间
	public final static byte[] KEYWORDTIMEMANYI = "keywordTimeManyi".getBytes();// 关键字"满意"出现的时间
	public final static byte[] KEYWORDTIMEBUQINGCHU = "keywordTimeBuqingchu"
			.getBytes();// 关键字"不清楚"出现的时间
	public final static byte[] KEYWORDTIMETINGBUQING = "keywordTimeTingbuqing"
			.getBytes();// 关键字"听不清"出现的时间
	public final static byte[] KEYWORDTIMEXIEXIE = "keywordTimeXiexie"
			.getBytes();// 关键字"谢谢"出现的时间
	public final static byte[] KEYWORDTIMEKEFU = "keywordTimeKefu".getBytes();// 关键字"客服"出现的时间
	public final static byte[] KEYWORDTIMEPEICHANG = "keywordTimeLipei"
			.getBytes();// 关键字"赔偿"出现的时间
	public final static byte[] KEYWORDTIMECHAOE = "keywordTimeChaoe".getBytes();// 关键字"超额"出现的时间
	public final static byte[] KEYWORDTIMEQIANMING = "keywordTimeQianming"
			.getBytes();// 关键字"签名"出现的时间
	public final static byte[] KEYWORDTIMEDUANXIN = "keywordTimeQianming"
			.getBytes();// 关键字"短信"出现的时间
	public final static byte[] KEYWORDTIMETAICHALE = "keywordTimeTaichale"
			.getBytes();// 关键字"太差了"出现的时间
	public final static byte[] KEYWORDTIMELIPEI = "keywordTimeLipei".getBytes();// 关键字"理赔"出现的时间
	public final static byte[] KEYWORDTIMEXIUGAI = "keywordTimeXiugai"
			.getBytes();// 关键字"修改"出现的时间
	public final static byte[] KEYWORDTIMEBUYAOLE = "keywordTimeBuyaole"
			.getBytes();// 关键字"不要了"出现的时间
	public final static byte[] KEYWORDCOUNTALL = "keywordTimeAll".getBytes();// 关键字出现的次数
	public final static byte[] KEYWORDCOUNTQISU = "keywordCountQisu".getBytes();// 关键字"起诉"出现的次数
	public final static byte[] KEYWORDCOUNTBUHELI = "keywordTimeBuheli"
			.getBytes();// 关键字"不合理"出现的次数
	public final static byte[] KEYWORDCOUNTYIJIAN = "keywordTimeYijian"
			.getBytes();// 关键字"意见"出现的次数
	public final static byte[] KEYWORDCOUNTFUWU = "keywordTimeFuwu".getBytes();// 关键字"服务"出现的次数
	public final static byte[] KEYWORDCOUNTTAIDU = "keywordTimeTaidu"
			.getBytes();// 关键字"态度"出现的次数
	public final static byte[] KEYWORDCOUNTYOUXIAOQI = "keywordTimeYouxiaoqi"
			.getBytes();// 关键字"有效期"出现的次数
	public final static byte[] KEYWORDCOUNTFEIBENREN = "keywordTimeFeibenren"
			.getBytes();// 关键字"非本人"出现的次数
	public final static byte[] KEYWORDCOUNTMANYI = "keywordTimeManyi"
			.getBytes();// 关键字"满意"出现的次数
	public final static byte[] KEYWORDCOUNTBUQINGCHU = "keywordTimeBuqingchu"
			.getBytes();// 关键字"不清楚"出现的次数
	public final static byte[] KEYWORDCOUNTTINGBUQING = "keywordTimeTingbuqing"
			.getBytes();// 关键字"听不清"出现的次数
	public final static byte[] KEYWORDCOUNTXIEXIE = "keywordCountQishu"
			.getBytes();// 关键字"起诉"出现的次数
	public final static byte[] KEYWORDCOUNTKEFU = "keywordCountKefu".getBytes();// 关键字"客服"出现的次数
	public final static byte[] KEYWORDCOUNTPEICHANG = "keywordCountLipei"
			.getBytes();// 关键字"赔偿"出现的次数
	public final static byte[] KEYWORDCOUNTCHAOE = "keywordCountChaoe"
			.getBytes();// 关键字"超额"出现的次数
	public final static byte[] KEYWORDCOUNTQIANMING = "keywordCountQianming"
			.getBytes();// 关键字"签名"出现的次数
	public final static byte[] KEYWORDCOUNTDUANXIN = "keywordCountDuanxin"
			.getBytes();// 关键字"短信"出现的次数
	public final static byte[] KEYWORDCOUNTTAICHALE = "keywordCountTaichale"
			.getBytes();// 关键字"太差了"出现的次数
	public final static byte[] KEYWORDCOUNTLIPEI = "keywordCountLipei"
			.getBytes();// 关键字"理赔"出现的次数
	public final static byte[] KEYWORDCOUNTXIUGAI = "keywordCountXiugai"
			.getBytes();// 关键字"修改"出现的次数
	public final static byte[] KEYWORDCOUNTBUYAOLE = "keywordCountBuyaole"
			.getBytes();// 关键字"不要了"出现的次数
	/**
	 * 临时表列信息
	 */
	public final static byte[] STATE = "state".getBytes();// 状态
	public final static byte[] FILEPATH = "filepath".getBytes();// 文件名及路径
}
