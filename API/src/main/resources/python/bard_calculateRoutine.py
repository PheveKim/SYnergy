import sys
import os
import bardapi

workingdirectory=os.getcwd()


def addition():
	os.environ['_BARD_API_KEY']=""
	
	input_text = sys.argv[1]
	
	response = bardapi.core.Bard().get_answer(input_text)
	print(response['content'])
	
addition()



