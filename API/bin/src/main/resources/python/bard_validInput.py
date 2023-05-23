import sys
import os
import bardapi

workingdirectory=os.getcwd()


def addition():
	os.environ['_BARD_API_KEY']=""
	
	input_text = sys.argv[1]
	input_tailInfo = " 이라는 문장에 욕설이 포함되어있나? 1번:있다, 2번:없다. 대답은 다음과 같은 형식으로만 대답해. ex) 1번."
	input_text += input_tailInfo

	response = bardapi.core.Bard().get_answer(input_text)
	print(response['content'])
	
addition()



