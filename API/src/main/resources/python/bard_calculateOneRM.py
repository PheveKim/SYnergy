import sys
import os
import bardapi

workingdirectory=os.getcwd()


def addition():
	os.environ['_BARD_API_KEY']=""
	
	input_text = sys.argv[1]
	input_tailInfo = " 일때, 각 3개 운동의 1RM 을 계산해줘. 계산 공식은 Epley, Brzycki, McGlothin 공식으로 계산하는데, 다음과 같은 공식으로 계산해. W는 무게이고 R은 횟수야. Epley 공식 : 1RM=W×(1+R/30), Brzycki 공식 : 1RM=W×(36/(37−R)), McGlothin 공식 : 1RM=100W/(101.3−2.67123R). 각 3개 공식에 대한 결과를 평균내서 알려줘. 대답은 다음과 같은 형식으로만 대답해. ex) 벤치프레스: 100kg, 데드리프트:120kg, 스쿼트:150kg"
	input_text += input_tailInfo

	response = bardapi.core.Bard().get_answer(input_text)
	print(response['content'])
	
addition()



