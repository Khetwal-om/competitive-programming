class Student:
	def __init__(self,name,marks):
		self.name=name
		self.marks=marks	

	def display(self):
		print(self.name)
		print(self.marks)


obj=Student("Jahn",20)
objB=Student("James",23)

obj.display()