package com.github.supermoonie.user32;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.win32.W32APIOptions;

/**
 * @author moonie
 */
public interface User32Ext extends User32 {
    User32Ext USER32EXT = (User32Ext) Native.loadLibrary("user32", User32Ext.class, W32APIOptions.DEFAULT_OPTIONS);

    /**
     * 发送事件消息
     *
     * @param hWnd        控件的句柄
     * @param dwFlags     事件类型
     * @param bVk         虚拟按键码
     * @param dwExtraInfo 扩展信息，传0即可
     * @return
     */
    int SendMessage(HWND hWnd, int dwFlags, byte bVk, int dwExtraInfo);

    /**
     * 发送事件消息
     *
     * @param hWnd   控件的句柄
     * @param Msg    事件类型
     * @param wParam 传0即可
     * @param lParam 需要发送的消息，如果是点击操作传null
     * @return
     */
    int SendMessage(HWND hWnd, int Msg, int wParam, String lParam);

    /**
     * 发送键盘事件
     *
     * @param bVk         虚拟按键码
     * @param bScan       传 ((byte)0) 即可
     * @param dwFlags     键盘事件类型
     * @param dwExtraInfo 传0即可
     */
    void keybd_event(byte bVk, byte bScan, int dwFlags, int dwExtraInfo);

    /**
     * 激活指定窗口（将鼠标焦点定位于指定窗口）
     *
     * @param hWnd    需激活的窗口的句柄
     * @param fAltTab 是否将最小化窗口还原
     */
    void SwitchToThisWindow(HWND hWnd, boolean fAltTab);

}
