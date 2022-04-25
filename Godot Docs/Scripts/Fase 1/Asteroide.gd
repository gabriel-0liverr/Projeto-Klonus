extends Node2D

var chosen = 0

func _ready():
	randomize()
	
	for a in $Asteroides.get_children():
		a.visible = false
	
	chosen = (randi() % $Asteroides.get_child_count()) + 1
	
	var node = get_node("Asteroides/Asteroid-" + str(chosen))
	
	node.visible = true
	
	$Area/CollisionShape.shape.radius = node.texture.get_width() / 2



func _process(delta):
	set_global_scale(Vector2(3,3))
	pass


func _on_Area_area_entered(area):
	queue_free()
