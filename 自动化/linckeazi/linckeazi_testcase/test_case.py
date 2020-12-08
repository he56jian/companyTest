import pytest
from selenium import webdriver
import yaml

def get_data():
    f = yaml.load(open('../linckeazi_data/login.yaml'))
    return f

class TestCase:
    def setup(self):
        self.driver = webdriver.Chrome()
        self.driver.get('https://www.linckeazi.com')
        # driver.get_cookies()  # 获取cookie信息，身份验证信息
        # driver.add_cookie(cookies的字典)  # 如果是get_cookies获取的是列表，可以遍历之后传入
        pass

    def teardown(self):
        # print(self.driver.page_source)
        pass

    @pytest.mark.parametrize('username,password',get_data())
    def test_login(self,username,password):
        # 测试登陆
        self.driver.find_element_by_id('login-user-name').send_keys(username)
        self.driver.find_element_by_id('login-user-password').send_keys(password)
        self.driver.find_element_by_class_name('tjbtn-log-in').click()
        print('登录成功')

    def test_logout(self):
        # 退出登陆
        pass

    def test_register(self):
        # 注册测试
        pass
