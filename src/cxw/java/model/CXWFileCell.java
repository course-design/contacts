package cxw.java.model;

import javafx.scene.control.TreeCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

/**
 * Created by kezhenxu on 4/12/15.
 */
public class CXWFileCell extends TreeCell<File> {

	@Override
	protected void updateItem ( File item, boolean empty ) {
		super.updateItem ( item, empty );
		if ( item == null || empty ) {
			setText ( null );
			setGraphic ( null );
			return;
		}
		if ( item.isDirectory () ) {
			setGraphic ( new ImageView ( new Image ( "cxw/resources/images/folder.png" ) ) );
		}
		String fileName = item.getName ();
		if ( item.getParentFile () == null ) {
			fileName = item.getAbsolutePath ();
		}
		setText ( fileName );
	}
}
