extends KinematicBody2D

var velocity = Vector2.ZERO
var move_speed = 200
var gravity = 1200
var jump_force = -720
var is_grounded
onready var raycasts = $raycasts
onready var _animated_sprite = $AnimatedSprite

func _physics_process(delta):
	
	velocity.y += gravity * delta;
	is_grounded = _check_is_grounded();
	
	_get_input();
	
	move_and_slide(velocity);
	
func _get_input():
	var move_direction = int(Input.is_action_pressed("move_right")) - int(Input.is_action_pressed("move_left"))
	velocity.x = move_speed * move_direction;
	velocity.x = lerp(velocity.x, move_speed * move_direction, 0.2);
	
	if(move_direction != 0):
		$AnimatedSprite.scale.x = move_direction;

func _input(event):
	if Input.is_action_pressed("jump") and is_grounded:
		velocity.y = jump_force / 2;


func _check_is_grounded():
	for raycast in raycasts.get_children():
		if(raycast.is_colliding()):
			return true;
		return false;

func _process(_delta):
	if Input.is_action_pressed("move_right") or Input.is_action_pressed("move_left"):
		if(!is_grounded):
			_animated_sprite.play("jump")
		else:
			_animated_sprite.play("run")
	elif !is_grounded:
		_animated_sprite.play("jump")
	else:
		_animated_sprite.play("idle")
