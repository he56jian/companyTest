from linckeazi.linckeazi_page.basepage import BasePage
from linckeazi.linckeazi_page.settings.devicesettingspage import DeviceSettingsPage


class MessageSettingsPage(BasePage):
    _currentEmail = 'on'

    def __init__(self, deviceID=0):
        self._currentDeviceID = deviceID

    def set_battery(self, num=0):
        # 设置电量提醒
        return self

    def set_sd_storage(self, num=[]):
        # 设置sd卡空间提醒
        return self

    def set_linckeazi_storage(self, num=[]):
        # 设置云存储空间提醒
        return self

    def set_temperature(self, switch='off', value=(0, 0)):
        if switch == "on":
            num, metric = value

        return self

    def switch_on_email(self):
        # 设置email开关
        return self

    def switch_off_email(self):
        # 关闭email开关
        return self

    def add_email(self, emails=[]):
        # 添加邮箱
        return self

    def del_emails(self, emails=[]):
        # 删除邮箱
        return self

    def update_email(self, oldemailid, new_email):
        # 修改邮箱
        return self

    def clear_email(self, oldemailid, ):
        #  清除邮箱内容
        return self

    def save_settings(self):
        return DeviceSettingsPage()
