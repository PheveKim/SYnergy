import sys
import os
import bardapi

workingdirectory=os.getcwd()


def addition():
	os.environ['_BARD_API_KEY']=""
	
	input_text = sys.argv[1]
	input_tailInfo = " 라고 하는 텍스트에서 어떤 운동부위에 관한 설명인지 다음중 하나를 골라 번호만 말해줘, 1번:등, 2번:가슴, 3번:하체, 4번:어깨, 5번:팔. 대답은 다음과 같은 형식으로만 대답해. ex) 1번."
	input_text += input_tailInfo

	response = bardapi.core.Bard().get_answer(input_text)
	print(response['content'])
	
addition()



