extends Node2D


func _ready():
	pass

func _process(delta):
	pass

#INICIAR
func _on_Iniciar_released():
	$Timer.start()
func _on_Timer_timeout():
	get_tree().change_scene("res://Scenes/Fase 1/Game.tscn")

#RANKING
func _on_Ranking_released():
	OS.shell_open("https://klonus-leaderboards.herokuapp.com/ranking")

#SETTINGS
func _on_Settings_released():
	$Popup.popup_centered()
func _on_Popup_about_to_show():
	$ScoreLayer/bestscore.visible = false
	$ScoreLayer/nickname.visible = false
	$Ranking.hide()
	$Settings.hide()
	$Iniciar.hide()
func _on_Popup_popup_hide():
	$ScoreLayer/bestscore.visible = true
	$ScoreLayer/nickname.visible = true
	$Ranking.show()
	$Settings.show()
	$Iniciar.show()
