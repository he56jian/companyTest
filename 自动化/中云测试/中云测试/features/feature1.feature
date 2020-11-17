# language: zh-CN
功能: 登录测试
登录测试

  场景大纲: 打开首页,并登录
    假如浏览到网站 "http://uliancloudtest.uovcloud.com"
    当在登录名一栏输入"<userName>"并点击其他位置
    而且在密码处，输入"<password>"并点击其他位置
    而且点击登录按钮
    那么当前状态码为"<status>"弹出的提示信息"<message>"
    例子: 
      | userName            | password        | status | message                                                   |
      | uovision020@163.com | uovisiontest123 | 200    |                                                           |
      | uovision020@163.com | 321             | 400    | Invalid username/email or password.                       |
      | tester001           | uovisiontest123 | 200    |                                                           |
      | tester001           | 12345           | 400    | Invalid username/email or password.                       |
      |                     | uovisiontest123 | 500    | Registered username/Email and password field is required. |
      | uovision020@163.com |                 | 500    | Registered username/Email and password field is required. |
      | tester1             |                 | 500    | Registered username/Email and password field is required. |
      |                     |                 | 500    | Registered username/Email and password field is required. |
      | te123123123123123   | uovisiontest123 | 400    | Invalid username/email or password.                       |