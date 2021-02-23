package curso.android;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.Projection;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;

public class PosOverlay extends Overlay {

	private GeoPoint geoPoint;
	
	@Override
	public void draw(Canvas canvas, MapView mapView, boolean shadow) {
		//Sempre que o objeto é renderizado
		if(shadow == false && geoPoint != null){
			Point point = new Point();
			
			Projection projextion = mapView.getProjection();
			projextion.toPixels(geoPoint, point);
			
			//Definir a cor
			Paint p = new Paint();
			p.setARGB(185, 0, 0, 255);
			
			//Define tamanho do circulo
			int raio = 25;
			RectF r = new RectF(point.x - raio, point.y - raio, point.x + raio, point.y + raio);
			
			//Desenhar o cirsculo
			canvas.drawOval(r, p);
			
			
		}
	}
	
	public void setGeoPoint(GeoPoint geoPoint){
		this.geoPoint = geoPoint;
	}
}
