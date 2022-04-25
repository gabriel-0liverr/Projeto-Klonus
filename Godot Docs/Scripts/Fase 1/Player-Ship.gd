extends Node2D

const PRE_LASER = preload("res://Scenes/Fase 1/Laser.tscn")

export(NodePath) var laseres

var vel = 150
onready var anim = $AnimationPlayer

func _ready():
	if laseres:
		laseres = get_node(laseres)
	else:
		laseres = get_parent()


func _process(delta):
	var dirX = 0
	var dirY = 0

	movement(dirX, dirY, delta)
	
	if Input.is_action_just_pressed("ui_accept"):
		if get_tree().get_nodes_in_group("laseres").size() < 5:
			var laser = PRE_LASER.instance()
			laseres.add_child(laser)
			laser.global_position = $Blaster.global_position
	
	pass

func movement(dirX, dirY, delta):
	if Input.is_action_pressed("ui_right"):
		dirX += 1
	if Input.is_action_pressed("ui_left"):
		dirX += -1
	if Input.is_action_pressed("ui_down"):
		dirY += 1
		anim.play("Down")
	elif Input.is_action_pressed("ui_up"):
		dirY += -1
		anim.play("Up")
	else:
		anim.play("Idle")
		
	translate(Vector2(dirX, dirY) * vel * delta)
	
	global_position.x = clamp(global_position.x, 180, 1100)
	global_position.y = clamp(global_position.y, 33, 699)
