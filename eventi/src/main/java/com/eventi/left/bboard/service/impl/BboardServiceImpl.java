package com.eventi.left.bboard.service.impl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.eventi.left.bboard.mapper.BboardMapper;
import com.eventi.left.bboard.service.BboardService;
import com.eventi.left.bboard.service.BboardVO;
import com.eventi.left.files.mapper.FilesMapper;
import com.eventi.left.files.service.FilesVO;
import com.eventi.left.reply.service.ReplyVO;

@Service
public class BboardServiceImpl implements BboardService{
	
	@Autowired BboardMapper bboardMapper;
	@Autowired FilesMapper filesMapper;
	
	//전체 조회
	@Override
	public List<BboardVO> bboardList(BboardVO bboardVO) {
		return bboardMapper.bboardList(bboardVO);
	}
	
	//단건 조회
	@Override
	public BboardVO bboardSelect(BboardVO bboardVO) {
		//조회수 +1
		bboardMapper.inqUpdate(bboardVO);
		return bboardMapper.bboardSelect(bboardVO);
	}
	
	//임시저장된 게시글 가져오기
	@Override
	public BboardVO bSave(BboardVO bboardVO) {
		return bboardMapper.bSave(bboardVO);
	}
	
	//좋아요 조회
	@Override
	public List<BboardVO> bboardLike(BboardVO bboardVO) {
		return bboardMapper.bboardLike(bboardVO);
	}

	//등록
	@Override
	public int bboardInsert(BboardVO bboardVO, FilesVO filesVO, MultipartFile uploadFile) {
			// 사진 등록
			String realFolder = "/files/bboard";
			File dir = new File(realFolder);
			if(!dir.isDirectory()) {
				dir.mkdirs();
			}
			
			filesVO.setFNm(uploadFile.getOriginalFilename());
			
			
			//파일 이름 저장
			String img = uploadFile.getOriginalFilename();
			
			//VO에 IMG 부분에 파일 이름 저장
			bboardVO.setImg(img);
		
		return bboardMapper.bboardInsert(bboardVO);
	}
	
	//수정
	@Override
	public int bboardUpdate(BboardVO bboardVO, MultipartFile uploadFile) {
		// 사진 등록
		String realFolder = "/files/bboard";
		File dir = new File(realFolder);
		if(!dir.isDirectory()) {
			dir.mkdirs();
		}
					
		//파일 이름 저장
		String img = uploadFile.getOriginalFilename();
					
		//VO에 IMG 부분에 파일 이름 저장
		bboardVO.setImg(img);
		
		return bboardMapper.bboardUpdate(bboardVO);
	}
	
	//삭제
	@Override
	public int bboardDelete(BboardVO bboardVO) {
		return bboardMapper.bboardDelete(bboardVO);
	}
	
	//댓글 리스트
	@Override
	public List<ReplyVO> bboardReply(ReplyVO reply) {
		return bboardMapper.bboardReply(reply);
	}

}
