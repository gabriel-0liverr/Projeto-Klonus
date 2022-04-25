extends Sprite

export(NodePath) var player

func _ready():
	if player:
		player = get_node(player)
	else:
		set_process(false)

func _process(delta):
	material.set_shader_param("desloc", (player.global_position.y - 350) * 0.0005)
