# SwitchButton
A switch like button.

# Resume

  这回写中文吧，这捉急英文水平可能有碍表达。有时间再写英文的ReadMe文档。
  
  这是一个类似按钮效果的开关按钮（也就是一边turn on 的时候另外一边会trun of）。挺简陋的一小东西，还是不试着往jCenter里面塞了，真要用的话把文件复制到项目里面就行。这个View提供了几个控制方法：
  
  1.setText(String leftSideString,String rightSideString)：顾名思义，就是给每个按钮上面附上字符串（建议不要太长）
    
  2.setChecked(boolean flag)和isChecked()，设置Check状态和获取Check状态，默认设置是左边颜色比较显眼的时候是true状态。不过颜色可以用下面的函数进行设置;
    
  3.setColor(int switchOnColor,int switchOffColor)和setColor(int switchOnColor,int switchOffColor,int textColor)。还是顾名思义，包含两个参数的可以设置左边按钮颜色和右边按钮颜色，包含三个参数的可以用来设置字体颜色：用法如下：
          
          switchButton.setColor(Color.parseColor("#CD1280"),Color.parseColor("#564891"));
          
  想要设置字体颜色的话：
          
          switchButton.setColor(Color.parseColor("#CD1280"),Color.parseColor("#564891")，Color.parseColor("#FFFFFF"));
          
  标志过时是因为如果用R.color.xxx来获取参数会出现莫名奇妙的错误。
  
  3.最后一个就是setMode(int switchMode)了，一共有三个：button_like，switch_normal，switch_default。自己拿去试着点一点就知道了。后面两个没有任何区别（没想好要干什么，欢迎大佬们来补充修改）。
 
 # 补充
  Layout里面的居中效果可以用layout_gravity来设置。如果在实际使用中发现什么不合适的，或者想要加特技的，欢迎一起来研究研究哈。
 
