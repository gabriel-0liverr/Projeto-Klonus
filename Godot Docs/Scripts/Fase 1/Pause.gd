extends Popup


# Called when the node enters the scene tree for the first time.
func _ready():
	pass # Replace with function body.


# Called every frame. 'delta' is the elapsed time since the previous frame.
#func _process(delta):
#	pass


func _on_Menu_released():
	get_tree().paused = false
	get_tree().change_scene("res://Scenes/Fase 1/Start_Menu.tscn")
