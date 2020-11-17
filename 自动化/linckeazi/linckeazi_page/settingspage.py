from linckeazi.linckeazi_page.basepage import BasePage
from linckeazi.linckeazi_page.settings.devicesettingspage import DeviceSettingsPage
from linckeazi.linckeazi_page.settings.messagesettingspage import MessageSettingsPage


class SettingsPage(BasePage):

    def show_device_settings(self, deviceID=1):
        # 显示相机设置
        return DeviceSettingsPage(deviceID)

    def show_message_settings(self,deviceID=1):
        # 显示消息设置
        return MessageSettingsPage(deviceID)
