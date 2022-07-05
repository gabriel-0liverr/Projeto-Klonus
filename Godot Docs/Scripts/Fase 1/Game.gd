extends Node2D


func _ready():
	PlayerData.scoreCurrent = 0
	get_tree().paused = true
	
func _process(delta):
	pass


func _on_Pause_pressed():
	get_tree().paused = true
	$Controls/Pause.hide()
	$Controls/Center.hide()
	$Controls/Down.hide()
	$Controls/DownLeft.hide()
	$Controls/DownRight.hide()
	$Controls/Fire.hide()
	$Controls/Left.hide()
	$Controls/Right.hide()
	$Controls/Up.hide()
	$Controls/UpLeft.hide()
	$Controls/UpRight.hide()
	$HUD/Contagem/Label.hide()
	$Pause.popup()


func _on_Voltar_released():
	$Pause.hide()
	$HUD/Contagem/Timer.start()
	$Controls/Pause.show()
	$Controls/Center.show()
	$Controls/Down.show()
	$Controls/DownLeft.show()
	$Controls/DownRight.show()
	$Controls/Fire.show()
	$Controls/Left.show()
	$Controls/Right.show()
	$Controls/Up.show()
	$Controls/UpLeft.show()
	$Controls/UpRight.show()
	$HUD/Contagem/Label.show()


func _on_Config_released():
	$Popup.popup()
	$Pause.hide()


func _on_Popup_popup_hide():
	$Pause.popup()
