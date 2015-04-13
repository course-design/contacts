package cxw.java.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

import java.io.File;
import java.util.stream.Stream;

/**
 * Created by kezhenxu on 4/12/15.
 */
public class CXWFileItem extends TreeItem<File> {

	private boolean isFirstCallGetChildren = true;
	private boolean isFirstCallIsLeaf      = true;
	private boolean isLeaf;

	public CXWFileItem ( File value ) {
		super ( value );
	}

	@Override
	public ObservableList<TreeItem<File>> getChildren () {
		if ( isFirstCallGetChildren ) {
			isFirstCallGetChildren = false;
			super.getChildren ().setAll ( buildChildren ( this ) );
		}
		return super.getChildren ();
	}

	@Override
	public boolean isLeaf () {
		if ( isFirstCallIsLeaf ) {
			isFirstCallIsLeaf = false;
			isLeaf = getValue ().isFile ();
		}
		return isLeaf;
	}

	private ObservableList<TreeItem<File>> buildChildren ( CXWFileItem hlFileItem ) {
		File directory = hlFileItem.getValue ();
		if ( directory.isFile () || directory.listFiles () == null ) {
			return FXCollections.emptyObservableList ();
		}
		ObservableList<TreeItem<File>> items = FXCollections.observableArrayList ();
		Stream.of ( directory.listFiles () )
				.filter ( f -> ! f.isHidden () )
				.forEach ( f -> items.add ( new CXWFileItem ( f ) ) );
		return items;
	}

	// TODO 判断文件是否是图片(jpg.png.gif........等等)
	private boolean isImage ( File file ) {
		boolean isImage = false;

		return isImage;
	}
}
