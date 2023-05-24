import sys
import os
import bardapi

workingdirectory=os.getcwd()


def addition():
	os.environ['_BARD_API_KEY']=""
	
	input_text = sys.argv[1]
	input_tailInfo = " 일때, 각 3개 운동의 1RM 을 계산해줘. 대답은 다음과 같은 형식으로만 대답해. ex) 벤치프레스: 100kg, 데드리프트:120kg, 스쿼트:150kg"
	input_text += input_tailInfo

	response = bardapi.core.Bard().get_answer(input_text)
	print(response['content'])
	
addition()



