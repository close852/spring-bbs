/**
 * @license Copyright (c) 2003-2019, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see https://ckeditor.com/legal/ckeditor-oss-license
 */
//https://ckeditor.com/docs/ckeditor4/latest/api/index.html
CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
//	 config.language = 'fr';
//	 config.uiColor = '#AADC6E';
	config.toolbarGroups = [
		{ name: 'styles', groups: [ 'styles' ] },
		{ name: 'clipboard', groups: [ 'clipboard', 'undo' ] },
		{ name: 'forms', groups: [ 'forms' ] },
		{ name: 'paragraph', groups: [ 'blocks', 'align', 'indent', 'list', 'bidi', 'paragraph' ] },
		{ name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ] },
		{ name: 'insert', groups: [ 'insert' ] },
		{ name: 'links', groups: [ 'links' ] },
		{ name: 'colors', groups: [ 'colors' ] },
		{ name: 'document', groups: [ 'doctools', 'mode', 'document' ] },
		{ name: 'editing', groups: [ 'find', 'selection', 'spellchecker', 'editing' ] },
		{ name: 'tools', groups: [ 'tools' ] },
		{ name: 'others', groups: [ 'others' ] },
		{ name: 'about', groups: [ 'about' ] }
	];
	config.removeButtons = 'Templates,Save,NewPage,Preview,PasteFromWord,Replace,SelectAll,Scayt,Form,Checkbox,Radio,TextField,Textarea,Select,Button,ImageButton,HiddenField,Subscript,Superscript,CopyFormatting,RemoveFormat,Blockquote,CreateDiv,BidiLtr,BidiRtl,Language,Anchor,Flash,Smiley,SpecialChar,PageBreak,Iframe,Styles,Format,Maximize,ShowBlocks,About,Print,Copy,Paste,PasteText,Cut,Find,Undo,Redo';
//	config.language = 'ko';			//언어설정
	config.uiColor = '#EEEEEE';		//ui 색상
	config.height = '300px';		//Editor 높이  
	config.width= 'auto';		//Editor 높이  
//	config.font_names='Gulim/Gulim;Dotum/Dotum;Batang/Batang;Gungsuh/Gungsuh/Arial/Arial;Tahoma/Tahoma;Verdana/Verdana';
	config.fontSize_defaultLabel = '14px';
//	config.fontSize_sizes='8/8px;9/9px;10/10px;11/11px;12/12px;14/14px;16/16px;18/18px;20/20px;22/22px;24/24px;26/26px;28/28px;36/36px;48/48px;';
	config.enterMode =CKEDITOR.ENTER_P;		//엔터키 입력시 p 태그 변경
	config.shiftEnterMode = CKEDITOR.ENTER_BR;	//엔터키 입력시 br 태그로 변경
	config.startupFocus = true;					// 시작시 포커스 설정
//	config.filebrowserImageUploadUrl = '/include/editor/upload/upload.asp';		//이미지 업로드 경로 (설정하면 업로드 플러그인에 탭이생김)
	config.toolbarCanCollapse = true;		//툴바가 접히는 기능을 넣을때 사용합니다.
	config.docType = "<!DOCTYPE html>";		//문서타입 설정
};