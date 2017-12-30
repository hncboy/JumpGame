JumpGame
===
##微信跳一跳辅助<br/>

###缘由<br/>
按照https://github.com/easyworld/PlayJumpJumpWithMouse这个项目写的<br/>
用java写的一个跳一跳辅助<br/>

##原理<br/>
1.用adb截图并用鼠标测量距离<br/>
adb shell screencap <filename> 保存截屏到手机<br/>
adb pull /sdcard/screen.png 下载截屏文件到本地<br/>
2.计算按压时间后模拟按压<br/>
adb shell input swipe <x1> <y1> <x2> <y2> [duration(ms)] (Default: touchscreen) 模拟长按<br/>
  
##操作<br/>
1.安卓手机用数据线连接电脑并打开USB调试(并且允许通过USB调试修改权限或模拟点击)<br/>
2.用鼠标操作点击两个方块的起始位置<br/>
