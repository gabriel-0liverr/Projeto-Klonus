extends KinematicBody2D

var gravity = 40
var speed = 250
var motion = Vector2()

func _physics_process(delta):
	_get_input()
	_animation()
	
	move_and_slide(motion)

func _get_input():
	var direction_x = int(Input.is_action_pressed("ui_right")) - int(Input.is_action_pressed("ui_left"))
	motion.x = direction_x * speed
	
	if(direction_x != 0):
		$AnimatedSprite.scale.x = direction_x
	
func _gravity_builder():
	motion.y += gravity
	
func _animation():
	if(Input.is_action_pressed("ui_right")) or Input.is_action_pressed("ui_left"):
		$AnimatedSprite.play("run") 
	else:
		$AnimatedSprite.play("idle")
		
	
