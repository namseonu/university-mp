package com.example.mobileprogramming.course06;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PathActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView vw = new MyView(this);
        setContentView(vw);
    }

    protected class MyView extends View {
        public MyView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            Path path = new Path();
            canvas.drawColor(Color.WHITE);

            Paint pnt = new Paint();
            pnt.setStrokeWidth(5);
            pnt.setColor(Color.RED);
            pnt.setStyle(Paint.Style.STROKE);

            // 원, 사각형을 패스로 정의한 후 출력
            path.addRect(100, 00, 150, 90, Path.Direction.CW);
            path.addCircle(50, 50, 40, Path.Direction.CW);
            canvas.drawPath(path, pnt);

            // 패스로 정의한 후 출력
            path.reset();
            path.moveTo(10, 110);
            path.lineTo(50, 150);
            path.lineTo(400, 10);
            pnt.setStrokeWidth(3);
            pnt.setColor(Color.BLUE);
            canvas.drawPath(path, pnt);

            // 패스 위에 텍스트 출력
            pnt.setTextSize(20);
            pnt.setStyle(Paint.Style.FILL);
            canvas.drawTextOnPath("Text on Path", path, 0, 0, pnt);
        }
    }
}
