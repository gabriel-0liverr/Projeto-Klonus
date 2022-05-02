extends CanvasLayer

var score = 0

func _ready():
	pass

func _process(delta):
	pass


func asteroid_destroied(ast):
	var pontos = (3 - ast.chosen) * 10
	score += pontos
	$score.text = str(score)

func inimigo_destroied(ast):
	score += 30
	$score.text = str(score)
