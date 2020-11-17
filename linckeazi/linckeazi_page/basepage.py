from linckeazi.linckeazi_page.messagepage import MessagePage
from linckeazi.linckeazi_page.personalpage import PersonalPage
from linckeazi.linckeazi_page.settingspage import SettingsPage


class BasePage:
    _currentpage = 'personalpage'  # 当前页面
    _currentDeviceID = 1  # 当前设备id
    _currentDeviceName = '' # 操作当前相机名称

    def logout(self):
        # 退出登陆
        pass

    def goto_personalpage(self):
        if self._currentpage != 'personalpage':
            # 进入主界面
            return PersonalPage()

    def goto_message(self):
        if self._currentpage != 'messagepage':
            # 进入消息页面
            return MessagePage()

    def goto_supportpage(self):
        if self._currentpage != 'supportpage':
            # 进入建议帮助界面
            return SupportPage()

    def goto_settingpage(self):
        if self._currentpage != 'settingpage':
            # 进入设置页面
            return SettingsPage(self._currentDeviceID)

    def goto_superviewpage(self):
        if self._currentpage != 'superviewpage':
            # 进入超级视图界面
            return SuperViewPage()

    def goto_locationpage(self):
        if self._currentpage != 'locationpage':
            # 进入地图界面
            return LocationPage()

    def goto_accountpage(self):
        if self._currentpage != 'accountpage':
            # 进入地图界面
            return AccountPage()
