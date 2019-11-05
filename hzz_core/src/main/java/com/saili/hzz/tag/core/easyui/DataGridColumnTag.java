package com.saili.hzz.tag.core.easyui;

import com.saili.hzz.core.util.MutiLangUtil;
import com.saili.hzz.core.util.StringUtil;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 
 * 类描述：列表字段处理项目
 * 
 * liuby
 * @date： 日期：2012-12-7 时间：上午10:17:45
 * @version 1.0
 */
public class DataGridColumnTag extends TagSupport {
	private static final long serialVersionUID = 1L;
	protected String title;
	protected String field;
	protected Integer width;
	//author：xugj start date:2016年5月11日 for:TASK #1080 【UI标签改造】t:dgCol 显示内容长度控制 -->
	protected Integer showLen;
	//author：xugj end date:2016年5月11日 for:TASK #1080 【UI标签改造】t:dgCol 显示内容长度控制 -->
	protected String rowspan;
	protected String colspan;
	protected String align;
	protected boolean sortable=true;
	protected boolean checkbox;
	protected String formatter;
	protected String formatterjs;//自定义函数名称(调用页面自定义js方法 参数为(value,row,index)

	protected boolean hidden=false;

	protected String replace;
	protected String treefield;
	protected boolean image;
	protected boolean query=false;
	private String queryMode = "single";//字段查询模式：single单字段查询；scope范围查询
	
	//protected boolean autoLoadData = true; // 列表是否自动加载数据
	private boolean frozenColumn=false; // 是否是冰冻列    默认不是
	protected boolean bSearchable=true;
	protected String url;//自定义链接
	protected String funname="openwindow";//自定义函数名称
	protected String arg;//自定义链接传入参数字段
	protected String dictionary;	//数据字典组编码
	protected boolean popup=false;	//是否启用popup模式选择 默认不启用
	protected String extend; //扩展属性
	protected String style; //Td的CSS
	protected String imageSize;//自定义图片显示大小
	protected String downloadName;//附件下载
	private boolean autocomplete = false;//自动完成
	private String extendParams;//扩展参数
	private String langArg;
	protected String editor;//高级查询用的编辑器

	private String defaultVal = "";//列默认值

	protected String showMode;//表单元素,查询表单中显示样式,默认样式select

	protected boolean newColumn = false;//是否新起一行

	protected String dictCondition; //自定义字典表的显示文本-字典查询条件

	private String filterType = "text";//过滤操作的类型
	private boolean optsMenu = false;//操作列风格转变 【船舶专用】

	private boolean isAjaxDict = false;

	public boolean isNewColumn() {
		return newColumn;
	}

	public void setNewColumn(boolean newColumn) {
		this.newColumn = newColumn;
	}

	public String getShowMode() {
		return showMode;
	}

	public void setShowMode(String showMode) {
		this.showMode = showMode;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}
	public int doEndTag() throws JspTagException {
		title = MutiLangUtil.doMutiLang(title, langArg);
		
		Tag t = findAncestorWithClass(this, DataGridTag.class);
		DataGridTag parent = (DataGridTag) t;

		parent.setColumn(title,field,width,showLen,rowspan,colspan,align,sortable,checkbox,formatter,formatterjs,hidden,replace,treefield,image,imageSize,query,url,funname,arg,queryMode, dictionary,popup,frozenColumn,extend,style,downloadName,autocomplete,extendParams,editor,defaultVal,showMode,newColumn,dictCondition,filterType,optsMenu,isAjaxDict);

		return EVAL_PAGE;
	}
	
	public void setDownloadName(String downloadName) {
		this.downloadName = downloadName;
	}

	public void setImageSize(String imageSize) {
		this.imageSize = imageSize;
	}

	public void setArg(String arg) {
		this.arg = arg;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setFunname(String funname) {
		this.funname = funname;
	}

	public void setbSearchable(boolean bSearchable) {
		this.bSearchable = bSearchable;
	}

	public void setQuery(boolean query) {
		this.query = query;
	}

	public void setImage(boolean image) {
		this.image = image;
	}

	public void setTreefield(String treefield) {
		this.treefield = treefield;
	}

	public void setReplace(String replace) {
		this.replace = replace;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setField(String field) {
		this.field = field;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public void setRowspan(String rowspan) {
		this.rowspan = rowspan;
	}

	public void setColspan(String colspan) {
		this.colspan = colspan;
	}

	public void setAlign(String align) {
		this.align = align;
	}

	public void setSortable(boolean sortable) {
		this.sortable = sortable;
	}

	public void setCheckbox(boolean checkbox) {
		this.checkbox = checkbox;
	}

	public void setFormatter(String formatter) {
		this.formatter = formatter;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	public int doStartTag() throws JspTagException {
		return EVAL_PAGE;
	}

	
	public void setDictionary(String dictionary) {
		this.dictionary = dictionary;
	}

	public void setdictCondition(String dictCondition) {
		this.dictCondition = dictCondition;
	}

	public String getQueryMode() {
		return queryMode;
	}

	public boolean isPopup() {
		return popup;
	}

	public void setPopup(boolean popup) {
		this.popup = popup;
	}

	public void setQueryMode(String queryMode) {
		this.queryMode = queryMode;
	}
	
	public boolean isFrozenColumn() {
		return frozenColumn;
	}

	public void setFrozenColumn(boolean frozenColumn) {
		this.frozenColumn = frozenColumn;
	}

	public String getExtend() {
		return extend;
	}

	public void setExtend(String extend) {
		this.extend = extend;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public void setAutocomplete(boolean autocomplete) {
		this.autocomplete = autocomplete;
	}

	public void setExtendParams(String extendParams) {

		if(StringUtil.isNotEmpty(extendParams) && !extendParams.endsWith(",")){
			extendParams = extendParams + ",";
		}

		this.extendParams = extendParams;
	}

	public void setLangArg(String langArg) {
		this.langArg = langArg;
	}

	public void setFormatterjs(String formatterjs) {
		this.formatterjs = formatterjs;
	}

	public Integer getShowLen() {
		return showLen;
	}

	public void setShowLen(Integer showLen) {
		this.showLen = showLen;
	}

	public String getDefaultVal() {
		return defaultVal;
	}

	public void setDefaultVal(String defaultVal) {
		this.defaultVal = defaultVal;
	}
	
	public String getFilterType() {
		return filterType;
	}
	public void setFilterType(String filterType) {
		this.filterType = filterType;
	}

	public boolean isOptsMenu() {
		return optsMenu;
	}

	public void setOptsMenu(boolean optsMenu) {
		this.optsMenu = optsMenu;
	}

	public void setIsAjaxDict(boolean isAjaxDict) {
		this.isAjaxDict = isAjaxDict;
	}

	public boolean getIsAjaxDict() {
		return isAjaxDict;
	}
	
}