package cxw.java.controller;

import cxw.java.model.CXWFileCell;
import cxw.java.model.CXWFileItem;
import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.io.File;
import java.util.stream.Stream;

/**
 * Created by kezhenxu on 4/12/15.
 */
public class CXWTreeController {

	// TODO 这里有一些东西做

	@FXML
	private TreeView<File> fileTree;

	// 初始化函数，当所有 fxml 中定义的控件被注入到本类完成后回调
	public void initialize () {
		fileTree.setCellFactory ( param -> new CXWFileCell () );
		initFileTree ();
	}

	// 为文件树填充数据
	private void initFileTree () {
		TreeItem<File> root = fileTree.getRoot ();
		Stream.of ( File.listRoots () )
				.filter ( f -> ! f.isHidden () )
				.forEach ( f -> root.getChildren ().add ( new CXWFileItem ( f ) ) );
	}

}
