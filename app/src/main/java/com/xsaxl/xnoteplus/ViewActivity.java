package com.xsaxl.xnoteplus;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentResolver;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Toast;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
public class ViewActivity extends AppCompatActivity implements
        SeekBar.OnSeekBarChangeListener, SurfaceHolder.Callback {
    private SurfaceView sv;
    private SurfaceHolder holder;
    private MediaPlayer mediaplayer;
    private RelativeLayout rl;
    private Timer timer;
    private TimerTask task;
    private SeekBar sbar;
    private ImageView play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题栏
        setContentView(R.layout.activity_view);


        Button be =(Button) findViewById(R.id.exit);
        be.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });


        sv = (SurfaceView) findViewById(R.id.sv);
        // 得到SurfaceView的容器,界面内容是显示在容器里面的
        holder = sv.getHolder();
        // 过时的APT,如果4.0以上的系统不写没问题,否则必须要写
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        holder.addCallback(this);
        rl = (RelativeLayout) findViewById(R.id.rl);
        play = (ImageView) findViewById(R.id.play);
        sbar = (SeekBar) findViewById(R.id.sbar);
        sbar.setOnSeekBarChangeListener(this);
        // 初始化计时器
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                if (mediaplayer != null && mediaplayer.isPlaying()) {
                    int total = mediaplayer.getDuration();
                    sbar.setMax(total);
                    int progress = mediaplayer.getCurrentPosition();
                    sbar.setProgress(progress);
                }else{

                    play.setImageResource(android.R.drawable.ic_media_play);
                }
            }
        };
        // 设置TimerTask延迟500ms,每隔500ms执行一次
        timer.schedule(task, 500, 500);
    }
    //SurfaceHolder创建完成时触发
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        try {
            mediaplayer = new MediaPlayer();
            mediaplayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            Uri uri =
                    Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE+"://"+
                            getPackageName()+"/"+R.raw.video);
            try {
                mediaplayer.setDataSource(ViewActivity.this,uri);
            } catch (IOException e) {
                Toast.makeText(ViewActivity.this,"播放失败",
                        Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
            mediaplayer.setDisplay(holder);
            mediaplayer.prepareAsync();
            mediaplayer.setOnPreparedListener(new
                                                      MediaPlayer.OnPreparedListener()
                                                      {
                                                          @Override
                                                          public void onPrepared(MediaPlayer mp) {
                                                              mediaplayer.start();
                                                          }
                                                      });
        } catch (Exception e) {
            Toast.makeText(ViewActivity.this, "播放失败",
                    Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
    //SurfaceHolder大小变化时触发
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {
    }
    //SurfaceHolder注销时触发
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        if(mediaplayer. isPlaying()){
            mediaplayer.stop();
        }
    }
    //播放暂停按钮的点击事件
    public void click(View view) {
        if (mediaplayer != null && mediaplayer.isPlaying()) {
            mediaplayer.pause();
            play.setImageResource(android.R.drawable.ic_media_play);
        } else {
            mediaplayer.start();
            play.setImageResource(android.R.drawable.ic_media_pause);
        }
    }
    //进度发生变化时触发
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress,
                                  boolean fromUser) {
    }
    //进度条开始拖动时触发
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }
    //进度条拖动停止时触发
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        int position = seekBar.getProgress();
        if (mediaplayer != null) {
            mediaplayer.seekTo(position);
        }
    }
    //屏幕触摸事件
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (rl.getVisibility() == View.INVISIBLE) {
                    rl.setVisibility(View.VISIBLE);
                    // 倒计时3秒
                    CountDownTimer cdt = new CountDownTimer(3000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            System.out.println(millisUntilFinished);
                        }
                        @Override
                        public void onFinish() {
                            rl.setVisibility(View.INVISIBLE);
                        }
                    };
                    cdt.start();
                } else if (rl.getVisibility() == View.VISIBLE) {
                    rl.setVisibility(View.INVISIBLE);
                }
                break;
        }
        return super.onTouchEvent(event);
    }
    //Activity注销时把Timer和TimerTask对象置为空
    @Override
    protected void onDestroy() {
        timer.cancel();
        task.cancel();
        timer = null;
        task = null;
        mediaplayer.release();
        mediaplayer = null;
        super.onDestroy();
    }
}
