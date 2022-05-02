extends Node2D


func _ready():
	pass

func _process(delta):	
	if $Options/Reiniciar.is_pressed():
		$Timer.start()
	pass
	
	if $Options/Sair.is_pressed():
		get_tree().change_scene("res://Scenes/Fase 1/Start_Menu.tscn")


func _on_Timer_timeout():
	get_tree().change_scene("res://Scenes/Fase 1/Game.tscn")
