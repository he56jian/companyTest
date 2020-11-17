from linckeazi.linckeazi_page.message.customerreplypage import CustomerReplyPage
from linckeazi.linckeazi_page.message.newpicturepage import NewPicturePage
from linckeazi.linckeazi_page.message.setmessagepage import SetMessagePage
from linckeazi.linckeazi_page.message.systemnoticficationpage import SystemNotificationPage


class MessagePage:
    def show_setmessage(self):
        # 展示设置页面消息
        return SetMessagePage()

    def show_newpicture(self):
        # 展示新图片消息
        return NewPicturePage()

    def show_customerreply(self):
        # 展示用户消息
        return CustomerReplyPage()

    def show_system_notification(self):
        # 展示系统消息
        return SystemNotificationPage()
