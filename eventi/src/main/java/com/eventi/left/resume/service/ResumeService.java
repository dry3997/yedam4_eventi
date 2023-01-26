package com.eventi.left.resume.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eventi.left.member.service.MemberVO;

@Service
public interface ResumeService {
	
	//구직자 전체조회(메인구인게시판-여러개시글)
	public List<ResumeBoardVO> getResumeList(ResumeBoardVO resumeBoardVO); 
		
	//구직자 전체조회(상세구인게시판-같은게시글)
	public List<ResumeBoardVO> getResumeJob(ResumeBoardVO resumeBoardVO); 
		
	//단건조회
	public ResumeBoardVO getResumeDetail(ResumeBoardVO resumeBoardVO); 
		
	//구직신청폼
	public ResumeBoardVO getApplyForm(MemberVO memberVO); 
		
	//구직신청폼 등록
	public int ApplyInsert(ResumeBoardVO resumeBoardVO);
	
	//구직자 채용
	public int hireUpdate(ResumeBoardVO resumeBoardVO);
	
	//구직자 미채용 
	public int unHireUpdate(ResumeBoardVO resumeBoardVO);

	public int hireUpdates(List<ResumeBoardVO> resumeBoardVO); 
}
