package com.eventi.left.bboard.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.eventi.left.files.service.FilesVO;
import com.eventi.left.reply.service.ReplyVO;

public interface BboardService {
	//전체조회
	public List<BboardVO> bboardList(BboardVO bboardVO);
	
	//단건조회
	public BboardVO bboardSelect(BboardVO bboardVO);
	
	//임시저장된 게시글 조회
	public BboardVO bSave(BboardVO bboardVO);
	
	//좋아요 조회
	public List<BboardVO> bboardLike(BboardVO bboardVO);
	
	//등록
	public int bboardInsert(BboardVO bboardVO, FilesVO filesVO, MultipartFile uploadFile);
	
	//수정
	public int bboardUpdate(BboardVO bboardVO, MultipartFile uploadFile);
	
	//삭제
	public int bboardDelete(BboardVO bboardVO);
	
	//게시글 댓글 조회
	public List<ReplyVO> bboardReply(ReplyVO reply);
}
