extends Node2D


func _ready():
	pass

func _process(delta):
	if Input.is_action_just_pressed("ui_select"):
		$Timer.start()
	pass
	
	if Input.is_action_just_pressed("ui_cancel"):
		get_tree().change_scene("res://Scenes/Fase 1/Start_Menu.tscn")


func _on_Timer_timeout():
	get_tree().change_scene("res://Scenes/Fase 1/Game.tscn")
