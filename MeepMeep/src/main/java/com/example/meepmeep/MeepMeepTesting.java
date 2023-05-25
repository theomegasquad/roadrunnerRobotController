package com.example.meepmeep;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeBlueDark;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeRedDark;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        System.setProperty("sun.java2d.opengl", "true");

/*
        public class amogh {

            private int intel;

            public amogh(int intel){
                this.intel = intel;
            }
            public funciton(int interger) {
                fsdflkjlkds
            }

        }

        amogh amoghObject = new amogh(1000000000000000000000);

        amoghObject.funciton(2);

        public int addition(int i1, int i2){
            return i1 + i2;
        }

        int sum = addition(5, 6);

        int name = 0;
*/
        MeepMeep meepMeep = new MeepMeep(600);
/*
        DefaultBotBuilder botBuilder = new DefaultBotBuilder(meepMeep);
        botBuilder.setColorScheme(new ColorSchemeBlueDark());
        botBuilder.setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15);
        botBuilder.followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(0, 0, 0))
                                .forward(30)
                                .turn(Math.toRadians(90))
                                .forward(30)
                                .turn(Math.toRadians(90))
                                .forward(30)
                                .turn(Math.toRadians(90))
                                .forward(30)
                                .turn(Math.toRadians(90))
                                .build()
        );


 */


        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep) //defaultBot
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setColorScheme(new ColorSchemeBlueDark())
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-36, 60, Math.toRadians(270)))
                                .splineTo(new Vector2d(-12, 36), Math.toRadians(270))
                                .splineTo(new Vector2d(-36, 0), Math.toRadians(270))
                                .build()
                );

        // Declare out second bot
        RoadRunnerBotEntity mySecondBot = new DefaultBotBuilder(meepMeep)
                // We set this bot to be red
                .setColorScheme(new ColorSchemeRedDark())
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(30, 30, Math.toRadians(180)))
                                .forward(30)
                                .turn(Math.toRadians(90))
                                .forward(30)
                                .turn(Math.toRadians(90))
                                .forward(30)
                                .turn(Math.toRadians(90))
                                .forward(30)
                                .turn(Math.toRadians(90))
                                .build()
                );
        meepMeep.setBackground(MeepMeep.Background.FIELD_POWERPLAY_OFFICIAL)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                //.addEntity(mySecondBot)
                .start();
    }
}