extends Node2D

var vel = 400

func _ready():
	pass
	
func _process(delta):
	set_global_scale(Vector2(3,2))
	translate(Vector2(1, 0) * vel * delta)


func _on_VisibilityNotifier2D_screen_exited():
	queue_free()

func _on_Area_area_entered(area):
	queue_free()
