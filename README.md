# SwitchButton
A switch like button.

# Resume

  这回写中文吧，这捉急英文水平不知道要写到什么时候才会写完。有时间再说。
  
  这是一个类似按钮效果的开关按钮（也就是一边turn on 的时候另外一边会trun of）。挺简陋的一小东西，还是不试着往jCenter里面塞了，真要用的话把文件复制到项目里面就行。这个View提供了几个控制方法：
  
  1.setText(String leftSideString,String rightSideString)：顾名思义，就是给每个按钮上面附上字符串，不建议写太长的字符。另外，如果不调用这个方法的话默认是没有字符显示的，光说不练，看图就知道了：
  
  ![](https://github.com/tjuksingle/SwitchButton/blob/master/sample/noText.png)
    
  2.setChecked(boolean flag)和isChecked()，设置Check状态和获取Check状态，默认设置是左边颜色比较显眼的时候是true状态。不过颜色可以用下面的函数进行设置;
    
  3.（Deprecated）setColor(int switchOnColor,int switchOffColor)和setColor(int switchOnColor,int switchOffColor,int textColor)。还是顾名思义，包含两个参数的可以设置左边按钮颜色和右边按钮颜色，包含三个参数的可以用来设置字体颜色：用法如下：
          
          switchButton.setColor(Color.parseColor("#CD1280"),Color.parseColor("#564891"));
          
  想要设置字体颜色的话：
          
          switchButton.setColor(Color.parseColor("#CD1280"),Color.parseColor("#564891")，Color.parseColor("#FFFFFF"));
          
  标志过时是因为如果用R.color.xxx来获取参数会出问题，但其实还是可以正常使用的,只不过必须使用Color.parseColor("#xxxxxx")。如果想要使用R.color.xxx的话，建议使用下面的方法：
  
  4.defColor(int switchOnColorRes,int switchOffColorRes)和defColoe(int switchOnColorRes,int switchOffColorRes,int textColorRes).示例代码如下：
  
        switchButton.defColor(R.color.SwitchOnColor,R.color.SwitchOffColor);
   
   或者：
   
        switchButton.defColor(R.color.SwitchOnColor,R.color.SwitchOffColor,R.color.TextColor);
  
  上面两个Method都可以设置多种多样的颜色，不同的颜色效果如下：
  
        switchButton.setColor(Color.parseColor("#712496"),Color.parseColor("#475869"));

  ![](https://github.com/tjuksingle/SwitchButton/blob/master/sample/%23712496and%23475869.PNG)
  
        switchButton.setColor(Color.parseColor("#CD0000"),Color.parseColor("#120000"));
  
  ![](https://github.com/tjuksingle/SwitchButton/blob/master/sample/%23CD0000and%23120000.PNG)
  
  文字颜色修改效果：
  
        switchButton.setColor(Color.parseColor("#CD1280"),Color.parseColor("#564891")，Color.parseColor("#0000FF"));
          
  ![](https://github.com/tjuksingle/SwitchButton/blob/master/sample/textColorSample.png)
  
  
  5.最后一个就是setMode(int switchMode)了，一共有三个：button_like，switch_normal，switch_default。自己拿去试着点一点就知道了。后面两个没有任何区别（没想好要干什么，欢迎大佬们来补充修改）。
  
  default和normal的样式如下：
  
  ![](https://github.com/tjuksingle/SwitchButton/blob/master/sample/defualt.gif)
  
  这两个目前还没什么区别，默认就是这个Mode，如果不需要设置成button_like的话，不需要添加setMode()方法。
  
  button_like的样式如下:
  
  ![](https://github.com/tjuksingle/SwitchButton/blob/master/sample/button_like.gif)
  
  如果Mode设置成button_like，true状态必须点右边的按钮才能切换成false状态。
 
 # layout中的设置
  宽度一般来说需要自行设置，或者和父布局保持一致；高度有一个固定的最大值，如果不合适可以去自定义View源文件里面找到maxHeightSize把它修改成合适的值。
  
  Layout里面的居中效果可以用layout_gravity来设置，支持margin来设置边界。
  
  如果在实际使用中发现什么不合适的，或者想要加特技的，欢迎一起来研究研究哈。
  
  最后的最后，如果喜欢这个View的话，希望可以点击Star按钮支持一下。
 
