package com.yc.pool;
/**
 * 回调接口
 * @author Administrator
 *
 */
public interface MyNotify {
	/**
	 * 回调方法:当子线程完成操作，向主线程同信
	 * @param obj 回调参数 用来存返回给主线程的结果
	 */
	public void notifyResult(Object obj);
}
