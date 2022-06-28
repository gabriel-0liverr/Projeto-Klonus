extends LineEdit 

func on_Login_pressed():
	UserData.addUser(self.text)
