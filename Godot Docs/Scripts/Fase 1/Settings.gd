extends Popup

var sfx_bus = AudioServer.get_bus_index("SFX")
var music_bus = AudioServer.get_bus_index("Musica")
var sfx_reset
var music_reset

func _ready():
	pass

func _on_Settings_about_to_show():
	if $Container/VBoxContainer/Sfx/CheckSfx.pressed:
		sfx_reset = true
	else:
		sfx_reset = false
	
	if $Container/VBoxContainer/Musica/CheckMusica.pressed:
		music_reset = true
	else:
		music_reset = false
	pass
	

func _on_Yes_released():
	if $Container/VBoxContainer/Sfx/CheckSfx.pressed:
		AudioServer.set_bus_mute(sfx_bus, false)
	else:
		AudioServer.set_bus_mute(sfx_bus, true)
	
	if $Container/VBoxContainer/Musica/CheckMusica.pressed:
		AudioServer.set_bus_mute(music_bus, false)
	else:
		AudioServer.set_bus_mute(music_bus, true)
		
	hide()

func _on_No_released():
	$Container/VBoxContainer/Sfx/CheckSfx.set_pressed_no_signal(sfx_reset)
	$Container/VBoxContainer/Musica/CheckMusica.set_pressed_no_signal(music_reset)
	hide()

